package concurrency.vars;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread thread1 = new CounterThread(counter);
        thread1.setName("Thread1");
        thread1.start();

        Thread thread2 = new CounterThread(counter);
        thread2.setName("Thread2");
        thread2.start();


    }
}
