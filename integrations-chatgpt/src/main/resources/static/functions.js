const inputElement = document.getElementById('parametroContent');

inputElement.addEventListener('keypress', function(event) {
    if (event.key === 'Enter' && inputElement.value.trim().length > 0){
        enviarMensagem();
    }
});
function enviarMensagem() {
    if ( inputElement.value.trim().length > 0){
        var userInput = document.getElementById('parametroContent').value;
        var chatBody = document.getElementById('chatBody');

        var message = '<div class="chat-message sent">';
        message += '<div class="message-content">' + userInput + '</div>';
        message += '</div>';
        chatBody.innerHTML += message;
        document.getElementById('parametroContent').value = ''; // Limpa o campo de entrada após enviar a mensagem
        chatBody.scrollTop = chatBody.scrollHeight; // Rolagem automática para a última mensagem

        buscarResposta(userInput);
    }

}

function buscarResposta(userInput) {
    var chatBody = document.getElementById('chatBody');
    var url = 'http://localhost:8080/bot/chat?content=' + encodeURIComponent(userInput);

    fetch(url)
        .then(response => response.json())
        .then(data => {
            var message = '<div class="chat-message received">';
            message += '<div class="message-content">' + data.choices[0].message.content + '</div>';
            message += '</div>';
            chatBody.innerHTML += message;
            chatBody.scrollTop = chatBody.scrollHeight; // Rolagem automática para a última mensagem
        })
        .catch(error => {
            console.error('Erro ao chamar a API:', error);
        });
}