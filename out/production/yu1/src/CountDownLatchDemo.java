import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountDownLatchDemo {

   /* public static void main(String[] args) throws InterruptedException {
        int totalThread = 3;
        long start = System.currentTimeMillis();
        CountDownLatch countDown = new CountDownLatch(totalThread);
        for (int i = 0;i < totalThread;i++){
            final String threadName = "Thread" + i;
            new Thread(() -> {
                System.out.println(String.format("%s\t%s %s",new Date(),threadName,"started"));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDown.countDown();
            }).start();
        }
        countDown.await();
        long stop = System.currentTimeMillis();
        System.out.println(String.format("Total time : %sms", (stop - start)));
    }*/

    @Test
    public void test(){
        Stream.generate(new Supplier<Double>() {
            @Override
            public Double get() {
                return Math.random();
            }
        });

        Stream.generate(() -> Math.random());
        Stream.generate(Math::random);

        Supplier<CountDownLatchDemo> sup= CountDownLatchDemo::new;
        List<String> strings = Arrays.asList("12,32,3");
        System.out.println(strings.stream().collect(Collectors.joining()));
    }

    public static void main(String args[]) {

    }
}