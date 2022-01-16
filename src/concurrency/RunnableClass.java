package concurrency;

public class RunnableClass implements Runnable {

    @Override
    public void run() {
        System.out.println(ThreadColor.ANSI_CYAN + "Hello form Runnable class");
    }
}
