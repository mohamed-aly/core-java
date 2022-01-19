package concurrency.concurrentutil;

import java.util.List;
import java.util.Random;

public class Producer implements Runnable {

    private List<String> buffer;
    private String color;

    public Producer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        String[] nums = {"1", "2", "3", "4", "5"};
        Random random = new Random();
        for (String s : nums) {
            try {
                System.out.println(color + "Adding... " + s);
                synchronized (buffer) {
                    buffer.add(s);
                }
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException ex) {
                System.out.println("Producer was interrupted!");
            }
        }
        System.out.println(color + "Adding EOF and exiting.");
        synchronized (buffer) {
            buffer.add("EOF");
        }
    }
}
