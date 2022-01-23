package concurrency.concurrentutil;

import concurrency.ThreadColor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        ReentrantLock lock = new ReentrantLock();
        Producer producer = new Producer(buffer, ThreadColor.ANSI_GREEN, lock);
        Consumer consumer1 = new Consumer(buffer, ThreadColor.ANSI_RED, lock);
        Consumer consumer2 = new Consumer(buffer, ThreadColor.ANSI_PURPLE, lock);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();

    }
}
