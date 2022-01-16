package concurrency;

public class AnotherThread extends Thread {
    //we can create thread by
    // 1- inheriting fom Thread class and override run()
    // 2- implementing Runnable interface and override run()


    @Override
    public void run() {
        System.out.println(ThreadColor.ANSI_BLUE + "Hello from " + this.getName());
        try{
            Thread.sleep(3000);
        }catch(Exception ex){
            System.out.println("Another Thread woke me up!");
        }

        System.out.println("three seconds have passed and I am awake");
    }
}
