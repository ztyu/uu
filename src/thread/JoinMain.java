package thread;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * thread.Join把指定的线程加入到当前线程，可以将两个交替执行的线程合并为顺序执行的线程。
 * 比如在线程B中调用了线程A的Join()方法，直到线程A执行完毕后，才会继续执行线程B
 */
public class JoinMain {

    public static void main(String[] args) {

        final Thread thread1 = new Thread(() -> System.out.println("t1 begin"),"t1");

        final Thread thread2 = new Thread(() -> {
            try {
                thread1.join(10);
                System.out.println("t2 begin");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2");

        Thread thread3 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    thread2.join(10);
                    System.out.println("t3 begin");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t3");

        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread3.join();
                    System.out.println("---");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread4.start();
        thread1.start();
        thread2.start();
        thread3.start();
    }



}
