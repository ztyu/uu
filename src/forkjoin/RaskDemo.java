package forkjoin;

import org.junit.Test;

import java.util.Date;
import java.util.concurrent.RecursiveAction;

public class RaskDemo extends RecursiveAction {

    private static final int Max = 20;

    private int start;
    private int end;

    public RaskDemo(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if ((end - start) < Max) {
            for (int i = 0; i < end; i++) {
                System.out.println(Thread.currentThread().getName() + "i的值" + i);
            }
        }else {
            int middle = (start + end) / 2;
            RaskDemo left = new RaskDemo(start, middle);
            RaskDemo right = new RaskDemo(middle,end);
            left.fork();
            right.fork();
        }


    }















}






































