package zeroSeven.observe;

import java.util.LinkedList;

public class MessageQueue {

    private LinkedList<Message> queue;
    private static int MAX_LIMIT = 100;
    private int limit;

    public MessageQueue() {
        this(MAX_LIMIT);
    }

    public MessageQueue(int limit) {
        this.queue = new LinkedList<>();
        this.limit = limit;
    }

    public void put(Message message) {
        synchronized (queue) {
            while (queue.size() > limit) {
                try {
                    queue.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            queue.addLast(message);
            queue.notifyAll();
        }
    }

    public Message take(){
        synchronized (queue) {
            while (queue.isEmpty()) {
                try {
                    queue.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Message message = queue.removeFirst();
            queue.notifyAll();
            return message;
        }

    }

}
