package thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

import org.junit.Test;

import static sun.misc.PostVMInitHook.run;

public class ThreadPoolTest {

    private static ThreadPoolExecutor ADD_TASK_THREAD_POOL = new ThreadPoolExecutor(20, 20, 8L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

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

        for(int i = 0; i< 100; i++) {
            addTask(i);
        }
        Thread.sleep(500000000);
        System.out.println("size : " + ADD_TASK_THREAD_POOL.getPoolSize());
        System.out.println("active : " + ADD_TASK_THREAD_POOL.getActiveCount());
        System.out.println("===== end =====");
    }


    private static SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Test
    public void availableProcessors() throws InterruptedException {
        ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);
        exec.scheduleWithFixedDelay(() -> {
            System.out.println("scheduleWithFixedDelay:begin," + format.format(new Date()));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("scheduleWithFixedDelay:end," + format.format(new Date()));
        },1000, 5000, TimeUnit.MILLISECONDS);

        Thread.sleep(20000);
    }

    @Test
    public void threadName() {


    }

}
