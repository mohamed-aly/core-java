package concurrency.producerandconsumer;

import java.util.Random;

class Writer implements Runnable {
    private Message message;

    public Writer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String[] messages = {"message 1", "message 2", "message 3", "message 4"};
        Random random = new Random();
        for (String s : messages) {
            message.write(s);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException ignored) {
            }

        }
        message.write("Finished");

    }
}
