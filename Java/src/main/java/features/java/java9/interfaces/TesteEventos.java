package features.java.java9.interfaces;

/**
 * @author Renan Sereia
 * @date 06/07/2025
 */
public class TesteEventos {
    public static void main(String[] args) {
        LogEventoI logEventoI = new LogEventoI() {
        };

        logEventoI.logError("Conexão falhou");
    }
}
