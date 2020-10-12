import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
    public void lambda() {
        List<Integer> numbers = Arrays.asList(2, 3, 5, 7);
        int sum = numbers.stream().mapToInt(x -> x).sum();
        System.out.println(sum);
    }



    @Test
    public void priorityTest(){
        Comparator<Integer> comparator = (o1,o2) -> o2-o1;
        PriorityQueue<Integer> queue = new PriorityQueue<>(comparator);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        for (int i = 0; i < 6; i++) {
            System.out.println(queue.poll());
        }
    }


    @Test
    public void big(){
        BigDecimal a = new BigDecimal(0);
        String b = "1";
        a = a.add(new BigDecimal(b));
        System.out.println(a);
    }


    public class Node {
        int val;
        Node head;
        Node next;
        public  Node(int val) {
            this.val = val;
        }
    }


    public Node receverNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node nextNode  = head.next;
        head.next = null;
        Node reverseRest  = receverNode(nextNode);
        nextNode.next = head;
        return reverseRest ;
    }


    @Test
    public void reTest() {
        Node node21 = new Node(7);
        Node node = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(6);
        node5.next = node1;
        node4.next = node5;
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;
        node.next = node1;
        node21.next = node;

        node1 = receverNode(node1);
        System.out.println(node1.next.next.next.val);

        System.out.println(loopNode(node1)+"----");
    }

    private static int loopNode(Node node) {
        Node fast = node;
        Node slow = node;
        while (fast != null ) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        return fast.val;
    }

    @Test
    public void tt() {
        sumWaterCoun();
        sumWaterCoun2();
    }

    private void sumWaterCoun() {
        int[] ls = {1, 8, 6, 2, 5, 4, 8, 3, 7} ;
        int l = ls.length;
        int s;
        int max = 0;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (ls[i] > ls[j]) {
                    s = ls[j] * (i - j);
                } else {
                    s = ls[i] * (i - j);
                }
                if (s > max) {
                    max = s;
                }
            }
        }
        System.out.println("最大面积是：" + max);
    }

    private void sumWaterCoun2() {
        int[] ls = {1, 8, 6, 2, 5, 4, 8, 3, 7} ;
        int l = ls.length;
        int s;
        int max = 0;
        int i = 0;
        int j = l -1;
        while (i < j) {
            s = (j - i) * Math.min(ls[i], ls[j]);
            //注意区分直接使用i++,j--的作用
            if (ls[i] < ls[j]) {
                i++;
            } else {
                j--;
            }
            if (s > max) {
                max = s;
            }
        }
        System.out.println("最大值：" + max);

    }


    @Test
    public void longestPalindromeTest(){
        longestPalindrome("abccba");
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int strLen = s.length();
        int maxStart = 0;  //最长回文串的起点
        int maxEnd = 0;    //最长回文串的终点
        int maxLen = 1;  //最长回文串的长度

        boolean[][] dp = new boolean[strLen][strLen];

        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;

                    }
                }

            }

        }
        return s.substring(maxStart, maxEnd + 1);

    }


    @Test
    public void test1() {
        numIdenticalPairs(new int[]{1,2,3,1,1,3});
    }


    public int numIdenticalPairs(int[] nums) {
        int[] cnt = new int[101];
        int ans = 0;
        for (int num : nums) {
            ans += cnt[num];
            cnt[num]++;
        }
        System.out.println(ans);
        return ans;
    }

    @Test
    public void threadTest2() throws InterruptedException {
        Thread thread1 = new Thread(() -> System.out.println("thread1 start"));
        Thread thread2 = new Thread(() -> {
            try {
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread2 start");});
        Thread thread3 = new Thread(() -> {
            try {
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread3 start");
        });
        thread3.start();
        thread1.start();
        thread2.start();

    }

    @Test
    public void threadTest3(){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("线程组执行结束");
            }
        });
        for (int i = 0; i < 10; i++) {
            new Thread(new readNum(i,cyclicBarrier)).start();
        }
        //CyclicBarrier 可以重复利用，
        // 这个是CountDownLatch做不到的
//        for (int i = 11; i < 16; i++) {
//            new Thread(new readNum(i,cyclicBarrier)).start();
//        }
    }
    static class readNum  implements Runnable {
        private int id;
        private CyclicBarrier cyc;

        public readNum(int id, CyclicBarrier cyc) {
            this.id = id;
            this.cyc = cyc;
        }

        @Override
        public void run() {
            synchronized (this) {
                System.out.println("id:" + id);
                try {
                    cyc.await();
                    Thread.sleep(100);
                    System.out.println("线程组任务" + id + "结束，其他任务继续");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }




    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= n-i) {
                return n-i;
            }
        }
        return -1;
    }


}
