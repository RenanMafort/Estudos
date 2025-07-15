package br.com.devdojo.varargs.annotations.injecao;

/**
 * @author Renan Sereia
 * @date 14/07/2025
 */
public class ClienteService {

    @Injetar
    private ServiceEmail service;

    public void processar() {
        service.enviar("Bem-vindo ao sistema!");
    }


}
