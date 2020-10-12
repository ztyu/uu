package zeroSeven.observe;

public class ConsumerThread implements Runnable {

    private MessageQueue messageQueue;
    public ConsumerThread(MessageQueue messageQueue , int seq) {
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        while (true){
            try {
                Message message = messageQueue.take();
                System.out.println(Thread.currentThread().getName() + "get MessageData：" + message.getData());
                Thread.sleep(100);
            }catch (Exception e){
                break;
            }

        }
    }
}
