package concurrency.producerandconsumer;

import java.util.Random;

class Reader implements Runnable {
    private Message message;

    public Reader(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (String latestMessages = message.read(); !latestMessages.equals("Finished");
             latestMessages = message.read()) {
            System.out.println(latestMessages);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException ignored) {
            }
        }
    }
}
