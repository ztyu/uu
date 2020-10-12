package model;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Math.max;
import static java.util.stream.Stream.*;

public class ObTest {


    @Test
    public void binaryTest() {
        //ob01 ob10 ob11 ob110
        int i = 0b110;
        System.out.println(i + "-------");
        System.out.println(i << 0b10);
        for (int n = 0; n < 10; n++) {
            System.out.println(Integer.toBinaryString(n));
        }
    }


    @Test
    public void obTest() {
        //0b01 0b10 0b11 0b110
        int i = 0b110;
        int j = 0b01;
        System.out.println(i);
        System.out.println(i & j);
        System.out.println(i | j);
        System.out.println(j | i);
        int m = 1;
        int n = 2;
        System.out.println(n & m);
        System.out.println(n | m);
    }

    @Test
    public void stream() {
        List<String> re = of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
    }

    @Test
    public void streamTest() {
        Stream<Integer> s1 = of(12, 4, 124, 12, 4);
        Stream<Integer> s2 = s1.parallel();
        s2.forEach(System.out::println);
        Integer[] integers = of(1, 3, 4).toArray(Integer[]::new);
    }

    /*
     * int sum = 0;
     *     for (int x : numbers) {
     *        sum += x;
     *     }
     *   int sum = numbers.stream().reduce(0, (x,y) -> x+y);
     */

    @Test
    public void tt() {
        String[] strArr = {"迪丽热巴,女", "郑爽,女", "杨紫,女"};
        printInfo(strArr, (message) -> {
            System.out.print("姓名:" + message.split(",")[0] + "。  ");
        }, (message) -> {
            System.out.println("性别:" + message.split(",")[1] + "。");

        });

    }

    public static void printInfo(String[] strArr, Consumer<String> con1, Consumer<String> con2) {
        for (int i = 0; i < strArr.length; i++) {
            con1.andThen(con2).accept(strArr[i]);
        }
    }


    @Test
    public void tete(){
        Thread[] e = new Thread[100];
        for (int i = 0; i < 100; i++) {
            e[i] = new Thread();

        }
    }

}
