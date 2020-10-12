import org.junit.Test;

import java.util.*;

public class YuTest {

    @Test
    public void tst() {
        int a = 10 >> 1;//a=5
        int b = a++;//b=5 a=5
        int c = ++a;//c=7  a=7
        int d = b * a++;//d=35  a=7
        System.out.println(a);//a=8
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }

    @Test
    public void streamCollectorsTest2() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
    }

    @Test
    public void test(){
        int i = 0x7fffffff;
        int j = 0x80000000;
        System.out.println(j);
    }

    @Test
    public void lambda(){
        List<Integer> numbers = Arrays.asList(new Integer[]{2,3,5,7});
        int sum = numbers.stream().mapToInt(x -> x).sum();
        System.out.println(sum);
    }




}
