package threads.aprimoramento.teste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ThreadSafeNames {

    private final List<String> names = new ArrayList<>();

    public synchronized void add(String name){
        names.add(name);
    }

    public synchronized void removeFirst(){
        if (names.size()> 0){
            System.out.println(Thread.currentThread().getName());
            System.out.println(names.remove(0));
        }
    }

}

public class ThreadSafeTest01 {
    public static void main(String[] args) {
        ThreadSafeNames tf = new ThreadSafeNames();
        tf.add("Renan");
//        Runnable runnable = () -> {
//            tf.removeFirst();
//        };
        Runnable runnable = tf::removeFirst;
        new Thread(runnable).start();
        new Thread(runnable).start();

    }
}
