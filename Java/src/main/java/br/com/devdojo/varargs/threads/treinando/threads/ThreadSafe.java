package br.com.devdojo.varargs.threads.treinando.threads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class ThreadSafeNames {
    private List<String> names = Collections.synchronizedList(new ArrayList<>());

    public void add(String name){
        this.names.add(name);
    }

    public void remove(){
        if (names.size() > 0){
            System.out.println(names.remove(0));
        }
    }
}

public class ThreadSafe {
    public static void main(String[] args) {
        ThreadSafeNames threadSafeNames = new ThreadSafeNames();
        threadSafeNames.add("Renan");

        Runnable r = threadSafeNames::remove;
        new Thread(r).start();
        new Thread(r).start();

    }
}
