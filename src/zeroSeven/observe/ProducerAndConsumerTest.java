package zeroSeven.observe;

public class ProducerAndConsumerTest {

    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue();
        Thread thread = new Thread(new ProducerThread(messageQueue , 1));
        Thread thread2 = new Thread(new ConsumerThread(messageQueue , 1));
        Thread thread3 = new Thread(new ProducerThread(messageQueue , 2));
        Thread thread4 = new Thread(new ConsumerThread(messageQueue , 2));
        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
