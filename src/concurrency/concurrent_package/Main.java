package concurrency.concurrent_package;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        ArrayBlockingQueue<String> list = new ArrayBlockingQueue<String>(6);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        MyProducer myProducer = new MyProducer(list, ThreadColor.ANSI_YELLOW);
        MyConsumer myConsumer = new MyConsumer(list, ThreadColor.ANSI_RED);
        MyConsumer myConsumer2 = new MyConsumer(list, ThreadColor.ANSI_BLUE);

        executorService.execute(myProducer);
        executorService.execute(myConsumer);
        executorService.execute(myConsumer2);

        Future<String> future = executorService.submit(() ->
                {
                    System.out.println(ThreadColor.ANSI_WHITE+"Callable");
                    return "this is the callable result";
                }
        );

        try{
            System.out.println(future.get());
        }catch (ExecutionException e){
            System.out.println("something went wrong");
        }catch(InterruptedException e){
            System.out.println("interrupted");
        }

        executorService.shutdown();

    }
}

class MyProducer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyProducer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num : nums) {
            try {
                System.out.println(color + "Adding..." + num);
                buffer.put(num);
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }
        System.out.println(color + "Adding EOF and exiting....");
        try{
            buffer.put("EOF");
        }catch (InterruptedException e){
        }



    }
}


class MyConsumer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        try{
            while (true) {
                synchronized (buffer){
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    if (buffer.peek().equals(Main.EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.take());
                    }
                }
            }
        }catch (InterruptedException e){
            System.out.println("interrupted");
        }
    }
}