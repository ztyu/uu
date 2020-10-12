package zeroSeven.observe;

import java.util.concurrent.atomic.AtomicInteger;

public class ProducerThread implements Runnable{

    private MessageQueue messageQueue;
    private static AtomicInteger count = new AtomicInteger(0);

    public ProducerThread(MessageQueue messageQueue, int seq) {
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message message = new Message("message" + count.getAndIncrement());
                messageQueue.put(message);
                System.out.println(Thread.currentThread().getName() + " Put MessageData" + message.getData());
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
