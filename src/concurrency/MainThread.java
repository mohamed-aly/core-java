package concurrency;

import java.sql.SQLOutput;

public class MainThread {

    public static void main(String[] args) throws InterruptedException {
        // the is a main thread process
        System.out.println(ThreadColor.ANSI_GREEN + "hello from the main thread.");
        Thread thread = new AnotherThread();

        //start() to invoke the new thread
        thread.start();

        new Thread(() -> System.out.println(ThreadColor.ANSI_PURPLE + "anonymous class process")).start();

        //this process will be executed before the new thread process
        System.out.println(ThreadColor.ANSI_RED + "Hello from the main thread again!");
    }
}
