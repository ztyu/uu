import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import demo.ListNode;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class SortTest {
    private static final String CALLBACK_URL="aa";


    /**
     * 归并排序
     * @param arr        排序数组
     * @param tempArr    临时存储数组
     * @param startIndex 排序起始位置
     * @param endIndex   排序终止位置
     */
    private static void mergeSort(int[] arr, int[] tempArr, int startIndex, int endIndex) {
        if (endIndex <= startIndex) {
            return;
        }
        //中部下标
        int middleIndex = startIndex + (endIndex - startIndex) / 2;

        //分解
        mergeSort(arr, tempArr, startIndex, middleIndex);
        mergeSort(arr, tempArr, middleIndex + 1, endIndex);

        //归并
        merge(arr, tempArr, startIndex, middleIndex, endIndex);
    }

    /**
     * 归并
     *
     * @param arr         排序数组
     * @param tempArr     临时存储数组
     * @param startIndex  归并起始位置
     * @param middleIndex 归并中间位置
     * @param endIndex    归并终止位置
     */
    private static void merge(int[] arr, int[] tempArr, int startIndex, int middleIndex, int endIndex) {
        //复制要合并的数据
        if (endIndex + 1 - startIndex >= 0)
            System.arraycopy(arr, startIndex, tempArr, startIndex, endIndex + 1 - startIndex);

        int left = startIndex;//左边首位下标
        int right = middleIndex + 1;//右边首位下标
        for (int k = startIndex; k <= endIndex; k++) {
            if (left > middleIndex) {
                //如果左边的首位下标大于中部下标,证明左边的数据已经排完了。
                arr[k] = tempArr[right++];
            } else if (right > endIndex) {
                //如果右边的首位下标大于了数组长度,证明右边的数据已经排完了。
                arr[k] = tempArr[left++];
            } else if (tempArr[right] < tempArr[left]) {
                arr[k] = tempArr[right++];//将右边的首位排入,然后右边的下标指针+1。
            } else {
                arr[k] = tempArr[left++];//将左边的首位排入,然后左边的下标指针+1。
            }
        }
    }

    @Test
    public void mergeSortTest() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(System.currentTimeMillis());
        //1588735168000
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = df.parse("2020-05-05");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        long timestamp = cal.getTimeInMillis();
        System.out.println(timestamp/1000);
    }


    @Test
    public void lcsTest(){
        String s1 = "ABCNDEFG";
        String s2 = "ABZDEFKG";
        System.out.println("最长公共子串长度：" + getLCS(s1, s2));
    }

    //最长公共子串
    //时间复杂度为O(n*m)，空间复杂度为O(n*m)
    public static int getLCS(String s1, String s2) {
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        // a.length行，b.length列
        int[][] result = new int[a.length + 1][b.length + 1];
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    result[i + 1][j + 1] = result[i][j] + 1;
                    max = Math.max(max, result[i + 1][j + 1]);
                }
            }
        }
        // ----- print table ----- 辅助理解 正常情况要简化代码
        System.out.print(" ");
        for (int i = 0; i < b.length; i++) {
            System.out.print(" " + b[i]); // 打印第一行
        }
        System.out.println();
        theEnd:
        for (int i = 1; i < result.length; i++) {
            System.out.print(a[i - 1] + " ");
            for (int j = 1; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
                if (result[i][j] == max) {
                    while (result[i][j] > 0) {
                        i--;
                        j--;
                        System.out.println("-----------" + a[i]);
                    }
                    break theEnd;
                    //System.out.println("-----------" + b[j - 1]);
                }
            }
            System.out.println();
        }
        System.out.println();
        // -----------------------
        return max;
    }

    //最长公共子序列
    public static int getLCS2(String s1, String s2) {
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        // a.length行，b.length列
        int[][] result = new int[a.length + 1][b.length + 1];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    result[i + 1][j + 1] = result[i][j] + 1;
                } else {
                    result[i + 1][j + 1] = Math.max(result[i][j + 1], result[i + 1][j]);
                }
            }
        }
        // ----- print table -----
        System.out.print(" ");
        for (int i = 0; i < b.length; i++) {
            System.out.print(" " + b[i]); // 打印第一行
        }
        System.out.println();
        for (int i = 1; i < result.length; i++) {
            System.out.print(a[i - 1] + " ");
            for (int j = 1; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        // -----------------------
        return result[a.length][b.length];
    }

    @Test
    public void tt(){
        ArrayList arrayList = new ArrayList<String>();
        arrayList.add("1");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
            arrayList.remove(i);

        }
        System.out.println(arrayList.size());
    }

    private void quitSort(int[] ints, int left, int right) {
        if (left > right) {
            return;
        }
        int l = left;
        int r = right;
        int k = ints[left];
        while (l < r) {
            while (l < r && ints[l] <= ints[k]) {
                l++;
            }
            while (l < r && ints[r] >= ints[k]) {
                r--;
            }
            if (ints[l]>ints[k]){
                swap(ints, l, r);
            }
        }
    }

    public void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    @Test
    public void quickSortTest(){
        int[] arr = new int[]{2,3,4,-1};
        int r = arr.length-1;
        quitSort(arr, arr[0], arr[r]);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    public static int diuShouJuan(int n){
        boolean[] arr = new boolean[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = true;
        }
        int leftCount = n;//报数的人数
        int countNum = 0;//要报的数
        int index = 0;//下标
        while(leftCount>1){
            if(arr[index]){
                countNum++;
                if(countNum==3){
                    countNum=0;
                    arr[index]=false;
                    leftCount--;
                }
            }
            index++;
            if(index==n)
                index=0;
        }
        int result=0;
        for (int i = 0; i < n; i++) {
            if(arr[i])
                result = i + 1;
        }
        return result;
    }

    public int[] TwoSum(int[] nums, int target) {
       int[] ary = new int[2];
       for (int i = 0; i < nums.length; i++) {
          for (int j = i + 1; j < nums.length; j++) {
             if (nums[i] + nums[j] == target) {
                  ary[0] = i;
                  ary[1] = j;
                  return ary;
             }
          }
       }
       return ary;
    }

    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = nums[i];
                res[1] = target - nums[i];
            }
            map.put(nums[i], i);

        }
        return res;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }


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


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode Head=new ListNode(0);
        Head.next=head;
        ListNode first=head;
        int length=0;
        while(first!=null){
            first=first.next;
            length++;
        }
        int count=length-n;
        first=Head;
        while(count>0){
            count--;
            first=first.next;
        }
        first.next=first.next.next;
        return Head.next;
    }


}
