package br.com.devdojo.varargs.exceptions.exceptioncustomizadas;

import java.util.Scanner;

public class LoginIvalidoException {
    public static void main(String[] args) {
        try {
            logar();
        } catch (LoginInvalidoException e) {
            e.printStackTrace();
        }
    }

    private static void logar() throws LoginInvalidoException {
        Scanner sc = new Scanner(System.in);
        String usernameDB="renan";
        String senhaDB="renan10";
        System.out.println("Usuario");
        String usernameDigitado = sc.nextLine();
        System.out.println("Senha");
        String senhaDigitado = sc.nextLine();
        if (!usernameDB.equalsIgnoreCase(usernameDigitado) || !senhaDB.equals(senhaDigitado)){
            throw new LoginInvalidoException();
        }
        System.out.println("Usuario logado com sucesso");
    }
}
