package melhorias.thread.sincronismo;

public class Account {
    private int balance = 50;

    public void withdrawal(int amount){
        this.balance = this.balance - amount;
    }

    public int getBalance(){
        return this.balance;
    }
}
