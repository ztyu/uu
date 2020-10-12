import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class SyncTest {

    //private static List<String> lockList = Collections.synchronizedList(new ArrayList<>());

    private ReentrantLock lock = new ReentrantLock();
    private static List<String> lockList = new ArrayList<>();

    private volatile AtomicInteger ii = new AtomicInteger();

    private void exec(){
        lock.lock();
        processor();
        System.out.println(lockList);
        System.out.println(ii.incrementAndGet());
        lock.unlock();
    }

    private void processor() {
        Random i = new Random();
        int ii = i.nextInt(20);
        if (ii < 12) {
            return;
        }
        lockList.clear();
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lockList.add("hhhhhhhhhhh22222");
    }

    private static final Map<String, Object> handlers = new ConcurrentHashMap<String, Object>();

    {
        handlers.put("user", new User());
    }

    @Test
    public void test() {
        ExecutorService pool = Executors.newFixedThreadPool(100);
        // 始终只有10个线程来处理请求任务，来不及处理的任务会放置于阻塞队列中
        for (int i = 0; i < 50; i++) {
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(handlers.get("user").hashCode());
                    User user = (User) handlers.get("user");
                    user.setName(Thread.currentThread().getName());
                    System.out.println("hello world! Execute ThreadName=" + user.getName());
                }
            });
        }

    }

    public class User {
        public User(){}

        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }



}
