package br.com.devdojo.varargs.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class CapturandoVariasExcecoes {
    public static void main(String[] args) {
        try {
            throw new ArrayIndexOutOfBoundsException();
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Dentro do ArrayIndexOutOfBoundsException");
        }catch (IndexOutOfBoundsException e){
            System.out.println("Dentro do IndexOutOfBoundsException");
        }catch (IllegalArgumentException | ArithmeticException e){
            System.out.println("Dentro do IllegalArgumentException");
        }

        try {
            talvezLanceException();
        } catch (SQLException | IOException e) {

        }
    }

    public static void talvezLanceException() throws SQLException, FileNotFoundException, IOException {

    };
}
