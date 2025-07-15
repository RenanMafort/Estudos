package br.com.devdojo.varargs.polimorfismo.servico;

import br.com.devdojo.varargs.polimorfismo.Repositorio;

public class RepositorioMysql implements Repositorio {
    @Override
    public void salvar() {
        System.out.println("Salvando no banco Mysql");
    }
}
