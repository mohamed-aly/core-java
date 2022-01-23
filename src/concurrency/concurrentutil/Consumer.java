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
        while (true) {
            lock.lock();
            if (buffer.isEmpty()) {
                lock.unlock();
                continue;
            }

            if (buffer.get(0).equals("EOF")) {
                System.out.println(color + "Exiting");
                lock.unlock();
                break;
            } else {
                System.out.println(color + "Removing... " + buffer.remove(0));
            }
            lock.unlock();

        }
    }
}
