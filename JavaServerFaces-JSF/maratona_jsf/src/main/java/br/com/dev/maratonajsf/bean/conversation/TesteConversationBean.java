package br.com.dev.maratonajsf.bean.conversation;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Renan on 14/01/2023.
 */
@Named
@ConversationScoped
public class TesteConversationBean implements Serializable {

    private List<String> personagens ;
    private List<String> personagemSelecionado= new ArrayList<>();

    @Inject
    private Conversation conversation;

    public void init(){
        System.out.println("Entrou no PostConstruct do ConversationScoped");
        personagens = Arrays.asList("AAAA", "BBBB", "CCCC");
        if (conversation.isTransient()){
            conversation.begin();
            System.out.println("Iniciando o conversation scoped ID=" + conversation.getId());
        }

    }

    public String endConversation(){
        if (!conversation.isTransient()){
            conversation.end();
        }

        return "conversation?faces-redirect=true" ;
    }


    public void selecionarPersonagem(){
        int index = ThreadLocalRandom.current().nextInt(3);
        String personagem = personagens.get(index);
        personagemSelecionado.add(personagem);

    }

    public List<String> getPersonagemSelecionado() {
        return personagemSelecionado;
    }

    public void setPersonagemSelecionado(List<String> personagemSelecionado) {
        this.personagemSelecionado = personagemSelecionado;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }
}
