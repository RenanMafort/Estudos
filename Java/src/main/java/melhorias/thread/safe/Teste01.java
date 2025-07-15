package melhorias.thread.safe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Teste01 {
    private final List<String> names = Collections.synchronizedList(new ArrayList<>());

    public synchronized void add(String name){
        names.add(name);
    }

    public synchronized void removeFirst(){
        if (!names.isEmpty()){
            System.out.println(Thread.currentThread().getName());
            names.remove(0);
        }
    }

    public static void main(String[] args) {
        Teste01 teste01 = new Teste01();
        teste01.add("Renan");

        Runnable r = teste01::removeFirst;
        new Thread(r).start();
        new Thread(r).start();

    }
}
