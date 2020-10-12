package model;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    private Semaphore smp = new Semaphore(3,true); //公平策略
    private Random rnd = new Random();

    class Task implements Runnable{
        private String id;
        Task(String id){
            this.id = id;
        }
        @Override
        public void run(){
            try {
                smp.acquire();
                //smp.acquire(int permits);//使用有参数方法可以使用permits个许可
                System.out.println("Thread " + id + " is working");
                System.out.println("在等待的线程数目："+ smp.getQueueLength());
                work();
                System.out.println("Thread " + id + " is over");
            } catch (InterruptedException e) {
            }
            finally
            {
                smp.release();
            }
        }

        public void work() {//假装在工作，实际在睡觉
            int worktime = rnd.nextInt(1000);
            System.out.println("Thread " + id + " worktime  is "+ worktime);
            try {
                Thread.sleep(worktime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        SemaphoreDemo semaphoreDemo = new SemaphoreDemo();
        ExecutorService se = Executors.newCachedThreadPool();
        se.submit(semaphoreDemo.new Task("a"));
        se.submit(semaphoreDemo.new Task("b"));
        se.submit(semaphoreDemo.new Task("c"));
        se.submit(semaphoreDemo.new Task("d"));
        se.submit(semaphoreDemo.new Task("e"));
        se.submit(semaphoreDemo.new Task("f"));
        se.shutdown();
    }
}