
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ThreadPoolTest {

    private static ThreadPoolExecutor ADD_TASK_THREAD_POOL = new ThreadPoolExecutor(4, 10, 8L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

    private class AsynchronousTaskAdder implements Runnable {
        private int i;
        AsynchronousTaskAdder(int i) {
            this.i = i;
        }
        @Override
        public void run() {
            System.out.println("task " + i + " start");

            System.out.println(i+"size : " + ADD_TASK_THREAD_POOL.getPoolSize());
            System.out.println(i+"active : " + ADD_TASK_THREAD_POOL.getActiveCount());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task " + i + " finished");
        }

    }

    private void addTask(int i) {
        ADD_TASK_THREAD_POOL.execute(new AsynchronousTaskAdder(i));
    }

    @Test
    public void testMain() throws InterruptedException {
        System.out.println("===== start =====");

        for(int i = 0; i< 10; i++) {
            addTask(i);
        }
        Thread.sleep(5000);
        System.out.println("size : " + ADD_TASK_THREAD_POOL.getPoolSize());
        System.out.println("active : " + ADD_TASK_THREAD_POOL.getActiveCount());
        System.out.println("===== end =====");
    }
}
