package br.com.devdojo.varargs.annotations.log;

import java.lang.reflect.Method;

/**
 * @author Renan Sereia
 * @date 14/07/2025
 */
public class Teste {
    public static void main(String[] args) throws Exception {
        MinhaClasse obj = new MinhaClasse();

        for (Method metodo : obj.getClass().getDeclaredMethods()) {
            if (metodo.isAnnotationPresent(MeuLog.class)) {
                MeuLog annotation = metodo.getAnnotation(MeuLog.class);
                System.out.println("[LOG] " + annotation.mensagem());
            }

            metodo.invoke(obj); // executa o método
        }
    }
}
