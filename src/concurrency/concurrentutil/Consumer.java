package concurrency.concurrentutil;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Consumer implements Runnable {

    private List<String> buffer;
    private String color;
    private ReentrantLock lock;

    public Consumer(List<String> buffer, String color, ReentrantLock lock) {
        this.buffer = buffer;
        this.color = color;
        this.lock = lock;
    }

    @Override
    public void run() {
        int counter = 0;
        while (true) {
            if (lock.tryLock()) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    System.out.println(color + "Counter = " + counter);
                    counter = 0;
                    if (buffer.get(0).equals("EOF")) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removing... " + buffer.remove(0));
                    }
                } finally {
                    lock.unlock();
                }
            }else{
                counter++;
            }
        }
    }
}
