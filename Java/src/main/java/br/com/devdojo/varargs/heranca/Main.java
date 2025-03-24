package br.com.devdojo.varargs.heranca;

public class Main {
    public static void main(String[] args) {
        Funcionario f = new Funcionario();
        f.setNome("Renan");
        f.setSalario(22.22);
        f.setCpf("1249124-1249012");
        f.setEndereco("asdkaso kasd");

        f.imprime();
    }
}
