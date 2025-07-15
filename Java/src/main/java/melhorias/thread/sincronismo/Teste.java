package melhorias.thread.sincronismo;

public class Teste implements Runnable {
    private Account account = new Account();

    public static void main(String[] args) {
        Teste teste = new Teste();
        Thread t1 = new Thread(teste, "Renan Sereia");
        Thread t2 = new Thread(teste, "Debora Sereia");

        t1.start();
        t2.start();
    }


    private  void withdrawal(int amount){
        synchronized (account){
            if (account.getBalance() >= amount){
                System.out.println(getThreadName() + " está indo sacar dinheiro!");
                account.withdrawal(amount);
                System.out.println(getThreadName() + " completou o saque, valor atual da conta - " + account.getBalance());
            }else {
                System.out.println("Sem dinheiro para " + getThreadName() + " efetuar o saque " + account.getBalance());
            }
        }

    }

    private static String getThreadName() {
        return Thread.currentThread().getName();
    }

    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            withdrawal(10);
            if (account.getBalance() < 0) {
                System.out.println("FODEOOOO");
            }
        }
    }
}
