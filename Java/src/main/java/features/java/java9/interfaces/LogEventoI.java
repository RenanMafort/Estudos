package features.java.java9.interfaces;

/**
 * @author Renan Sereia
 * @date 06/07/2025
 */
public interface LogEventoI {
    default void logInfo(String mensagems){
        log(mensagems,"INFO");
    }

    default void logWarn(String mensagems){
        log(mensagems,"WARN");
    }

    default void logError(String mensagems){
        log(mensagems,"ERROR");
    }

    default void logFatal(String mensagems){
        log(mensagems,"FATAL");
    }

    private void log(String mensagem,String tipo){
        System.out.println("INICIO DA MENSAGEM");

        System.out.println(tipo + ": "+ mensagem);

        System.out.println("FIM DA MENSAGEM");
    }

}
