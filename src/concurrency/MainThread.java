package concurrency;

import java.sql.SQLOutput;

public class MainThread {

    public static void main(String[] args) throws InterruptedException {
        // the is a main thread process
        System.out.println(ThreadColor.ANSI_GREEN + "hello from the main thread.");
        Thread thread = new AnotherThread();
        thread.setName("== Another Thread==");

        //start() to invoke the new thread
        thread.start();

        new Thread(() -> System.out.println(ThreadColor.ANSI_PURPLE + "anonymous class process")).start();

        //this process will be executed before the new thread process
        System.out.println(ThreadColor.ANSI_RED + "Hello from the main thread again!");

        //initiating Thread by runnable class
        Thread runnableThread = new Thread(new RunnableClass());
        runnableThread.start();

        //creating anonymous runnable thread
        new Thread(() -> System.out.println(ThreadColor.ANSI_RESET + "Hello from anonymous Runnable!")).start();
    }
}
