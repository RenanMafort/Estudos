package br.com.devdojo.varargs.annotations.injecao;

/**
 * @author Renan Sereia
 * @date 14/07/2025
 */
public class Testar {
    public static void main(String[] args) throws Exception {
        ClienteService service = new ClienteService();
        Injetor.injetarDependencias(service);
        service.processar();
    }
}
