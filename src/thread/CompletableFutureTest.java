package thread;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest {

    @Test
    public void completableTest() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                preOperate();
            } catch (Exception e)
            {
                System.out.println(e.getMessage()+"---1");
                e.printStackTrace();
            }
        });
        future.get();
        System.out.println("------------hi");
    }

    private void preOperate() throws Exception{
        try {
            System.out.println("-----------------bu");
            Thread.sleep(1000l);
            throw new RuntimeException();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ttt() {
        JSONObject jsonObject = new JSONObject();
        System.out.println(jsonObject.isEmpty());
        int i = 1;
        System.out.println(i + (i & 0xff));
    }


    @Test
    public void tttt() {
        int i = 0;
        i = i++;
        System.out.println("i=" + i);
    }

    /**
     * 最长不重复字符串
     */
    public static int longestOfStr(String string) {
        Set<Character> str = new HashSet<>();
        int lef = 0, rig = -1, n = string.length();
        for (int i = 0; i < n; ++i) {
            if (0 != i) {
                str.remove(string.charAt(i - 1));
            }
            while (rig + 1 < n && !str.contains(string.charAt(rig + 1))) {
                str.add(string.charAt(rig + 1));
                ++rig;
            }
            System.out.println(rig - i + 1);
            System.out.println("lef-------------" + lef);
            lef = Math.max(lef, rig - i + 1);
        }
        return lef;
    }

    @Test
    public void longestOfStrTest(){
        longestOfStr("abcabcbb");//3
    }


    private static void QuickSort(int[] num, int left, int right){
        // 如果left=right，即数组中只剩一个元素时，直接返回
        if (left >= right){
            return;
        }
        // 设置最左边的元素为基准值
        int key = num[left];
        // 数组中比key小的放在左边，比key大的放在右边
        int i = left;
        int j = right;
        while (i < j){
            // j向左移动，直到碰到比key小的数
            while (num[j] >= key && i < j) {
                j--;
            }
            // i向右移动，直到碰到比key大的数
            while (num[i] <= key && i < j) {
                i++;
            }
            // i和j指向的元素交换
            if (i < j){
                int temp = num[i];
                num[i] = num[j];
                num[j] = temp;
            }
        }
        num[left] = num[i];
        num[i] = key;
        QuickSort(num, left, i-1);
        QuickSort(num, i+1, right);
    }

    @Test
    public void teee() {
        int[] arr = {7, 2, 5, 3, 8};
        QuickSort(arr, 0, arr.length - 1);
        for (int i1 : arr) {
            System.out.println(i1);
        }
    }


}

