package concurrency.concurrentutil;

import concurrency.ThreadColor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        Producer producer = new Producer(buffer, ThreadColor.ANSI_GREEN);
        Consumer consumer1 = new Consumer(buffer, ThreadColor.ANSI_RED);
        Consumer consumer2 = new Consumer(buffer, ThreadColor.ANSI_PURPLE);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();

    }
}
