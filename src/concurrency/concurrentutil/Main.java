package concurrency.concurrentutil;

import concurrency.ThreadColor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<>(6);
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Producer producer = new Producer(buffer, ThreadColor.ANSI_GREEN);
        Consumer consumer1 = new Consumer(buffer, ThreadColor.ANSI_RED);
        Consumer consumer2 = new Consumer(buffer, ThreadColor.ANSI_PURPLE);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        Future<String> future = executorService.submit(() -> {
            System.out.println(ThreadColor.ANSI_GREEN + "inside callable hoba");
            return "this is callable future";
        });

        try{
            System.out.println(future.get());
        }catch(ExecutionException e){
            System.out.println("something went wrong");
        }catch (InterruptedException e){
            System.out.println("Thread Interrupted");
        }
        //should be closed manually
        executorService.shutdown();


    }
}
