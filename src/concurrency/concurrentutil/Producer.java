package concurrency.concurrentutil;

import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Producer implements Runnable {

    private List<String> buffer;
    private String color;
    private ReentrantLock lock;

    public Producer(List<String> buffer, String color, ReentrantLock lock) {
        this.buffer = buffer;
        this.color = color;
        this.lock = lock;
    }

    @Override
    public void run() {
        String[] nums = {"1", "2", "3", "4", "5"};
        Random random = new Random();
        for (String s : nums) {
            try {
                System.out.println(color + "Adding... " + s);
                lock.lock();
                buffer.add(s);
                lock.unlock();
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException ex) {
                System.out.println("Producer was interrupted!");
            }
        }
        System.out.println(color + "Adding EOF and exiting.");
        lock.lock();
        buffer.add("EOF");
        lock.unlock();
    }
}
