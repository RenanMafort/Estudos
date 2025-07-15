package br.com.devdojo.varargs.annotations.log;

/**
 * @author Renan Sereia
 * @date 14/07/2025
 */
public class MinhaClasse {

    @MeuLog(mensagem = "Testando metodo")
    public void metodoWithLog(){
        System.out.println("Executando lógica do método importante.");
    }

    public void metodoSemLog() {
        System.out.println("Outro método qualquer.");
    }
}
