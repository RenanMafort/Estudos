package features.java.java19;

/**
 * @author Renan Sereia
 * @date 13/07/2025
 */
public class VirtualThreads {
    public static void main(String[] args) {
        try {
            Thread start = Thread.ofVirtual().start(() -> System.out.println("Olá, eu sou uma thread Virtual"));
            start.join();

            System.out.println("Até logo");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
