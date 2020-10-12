package model.product;

import java.util.concurrent.BlockingQueue;

public class Product implements Runnable {

    private final BlockingQueue blockingQueue;

    public Product(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    private int BLOCK_SIZE = 10;

    int task = 1;

    @Override
    public void run() {
        while (true) {
            try {
                blockingQueue.put(task);
                task++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
