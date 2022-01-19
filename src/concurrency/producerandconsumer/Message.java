package concurrency.producerandconsumer;

class Message {
    private String message;
    private boolean empty = true;

    public synchronized String read() {
        while (empty) {
            //if empty wait until you get notified to get the lock
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }
        this.empty = true;
        notifyAll();
        return message;
    }

    public synchronized void write(String message) {
        while (!empty) {
            try {
                //if not empty wait until you get notified to get the lock
                wait();
            } catch (InterruptedException ignored) {
            }
        }
        empty = false;
        this.message = message;
        //notify the other threads
        notifyAll();
    }
}
