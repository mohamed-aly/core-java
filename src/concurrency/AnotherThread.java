package concurrency;

public class AnotherThread extends Thread {
    //we can create thread by
    // 1- inheriting fom Thread class and override run()
    // 2- implementing Runnable interface and override run()


    @Override
    public void run() {
        System.out.println(ThreadColor.ANSI_BLUE + "Hello from another class");
    }
}
