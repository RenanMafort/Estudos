package br.com.devdojo.varargs.exceptions;

public class RunTimeExceptionTest3 {
    public static void main(String[] args) {
        System.out.println(abreConexão());
    }

    private static String abreConexão() {
        try {
            System.out.println("Abrindo Arquivo");
            System.out.println("Escrevendo dados no arquivo");
            System.out.println("Fechando arquivo");
            return "Conexão aberta";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Sempre executara");
        }
        return null;
    }
}
