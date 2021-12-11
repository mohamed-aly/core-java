package concurrency.thread_variables;

public class Application {
    public static void main(String[] args) {
        CountDown countDown = new CountDown();

        Thread thread1 = new CountDownThread(countDown);
        thread1.setName("Thread 1");
        Thread thread2 = new CountDownThread(countDown);
        thread2.setName("Thread 2");

        thread1.start();
        thread2.start();

    }
}

class CountDown{
    private int i;

    public void doCountDown(){

        String color;
        switch (Thread.currentThread().getName()){
            case "Thread 1":
                color=ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color=ThreadColor.ANSI_GREEN;
                break;
            default:
                color=ThreadColor.ANSI_RED;
        }

        for(i = 10; i>0; i--){
            System.out.println(color+Thread.currentThread().getName()+": i = "+i);
        }
    }
}

class CountDownThread extends Thread{
    private CountDown countDown = new CountDown();

    public CountDownThread(CountDown countDown){
        this.countDown=countDown;
    }

    @Override
    public void run() {
        countDown.doCountDown();
    }
}
