package br.com.devdojo.varargs.annotations.log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Renan Sereia
 * @date 14/07/2025
 */

@Retention(RetentionPolicy.RUNTIME) // Disponível em tempo de execução
@Target(ElementType.METHOD)         // Só pode ser usada em métodos
public @interface MeuLog {
    String mensagem() default "Executando método...";
}
