package Product;

import org.junit.Test;

import java.util.*;

public class PublicBox {

    private int apple = 0;

    public synchronized void increate(){
        while (apple == 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            apple++;
            System. out .println("生成苹果成功！" );
            notify();
        }
    }

    public synchronized void decreace() {
        while (apple == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        apple--;
        System. out.println( "消费苹果成功！" );
        notify();
    }

    @Test
    public void te(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        Collections.fill(list,2);
    }


}
