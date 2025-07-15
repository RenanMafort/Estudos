package br.com.devdojo.varargs.annotations.injecao;

import java.lang.reflect.Field;

/**
 * @author Renan Sereia
 * @date 14/07/2025
 */
public class Injetor {
    public static void injetarDependencias(Object obj) throws Exception {
        for (Field campo : obj.getClass().getDeclaredFields()) {
            if (campo.isAnnotationPresent(Injetar.class)) {
                campo.setAccessible(true);
                Object instancia = campo.getType().getDeclaredConstructor().newInstance();
                campo.set(obj, instancia);
            }
        }
    }
}
