package concurrency.vars;

import concurrency.ThreadColor;

public class Counter {

    private int i;

    public void countDown() {
        String color;

        switch (Thread.currentThread().getName()) {
            case "Thread1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread2":
                color = ThreadColor.ANSI_GREEN;
                break;
            default:
                color = ThreadColor.ANSI_RED;
        }

        for (i = 10; i > 0; i--) {
            System.out.println(color + Thread.currentThread().getName() + " i = " + i);
        }
    }

}
