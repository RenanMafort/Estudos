package threads.concorrencia;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MapReadWrite {
    private final Map<String, String> map = new LinkedHashMap<>();
    private final ReentrantReadWriteLock rwl;

    public MapReadWrite(ReentrantReadWriteLock rwl) {
        this.rwl = rwl;
    }

    public void put(String key, String value) {
        rwl.writeLock().lock();
        try {
            if (rwl.isWriteLocked()) {
                System.out.printf("%s obteve o WRITE lock%n", Thread.currentThread().getName());
            }
            map.put(key, value);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwl.writeLock().unlock();
        }
    }

    public Set<String> allKeys() {
        rwl.readLock().lock();
        try {
            return map.keySet();
        } finally {
            rwl.readLock().unlock();
        }
    }
}

public class ReentrantReadWriteLockTest01 {
    public static void main(String[] args) {
        ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
        MapReadWrite mapReadWrite = new MapReadWrite(rwl);

        Runnable writer = () -> {
            for (int i = 0; i < 20; i++) {
                mapReadWrite.put(String.valueOf(i), String.valueOf(i));
            }
        };

        Runnable reader = () -> {
            if (rwl.isWriteLocked()) {
                System.out.println("WRITE LOCKED!");
            }
            rwl.readLock().lock();
            System.out.println("FINALLY I GOT THE DAMN LOCK");
            try {
                System.out.println(Thread.currentThread().getName() + " " + mapReadWrite.allKeys());
            }finally {
                rwl.readLock().unlock();
            }
        };

        Thread thread1 = new Thread(writer);
        Thread thread2 = new Thread(reader);
        Thread thread3 = new Thread(reader);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
