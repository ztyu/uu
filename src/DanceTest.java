import demo.ListNode;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import javax.swing.text.html.Option;
import javax.swing.tree.TreeNode;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DanceTest {


    private static Node reverseList(Node head) {
        Node next = null;//指向当前节点的后驱
        Node pre = null;//指向当前节点的前驱
        while (head != null) {
            next = head.next;
            //当前节点的后驱指向前驱
            head.next = pre;
            pre = head;
            //处理下一个节点
            head = next;
        }
        return pre;
    }

    //用递归的方法反转链表
    private static Node reverseList2(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        //递归反转子lian链表
        Node newList = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newList;
    }


    class Node {
        int value;
        Node pre;
        Node next;

        public Node(int data) {
            this.value = data;
        }


    }

    class LinkNodeYU{
        Node first;
        Node last;

        private void addNode(int val) {
            Node l = last;
            Node node = new Node(val);
            last = node;
            if (l == null) {
                first = node;
            }else{
                l.next = node;
            }
        }

    }


    @Test
    public void reverseNodeTest() {
      /*  Node node = new Node(1);
        node.addNode(node,2);
        node.addNode(node,3);
        reverseList2(node);*/
        LinkedList linkedList = new LinkedList();
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

    }


    static void LeftView(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        //设置 size 和 child 两个标记，child在循环中会变，size不会变，作为循环条件
        //第一层只有根节点1个，所以size = 1
        int size = 1;
        //记录孩子数
        int child;
        while (!queue.isEmpty()) {
            //初始化孩子数为 0
            child = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node1 = queue.poll();
                // i = 0,说明是该层第一个结点
                if (i == 0) {
                    System.out.println(node1.val);
                }
                if (node1.left != null) {
                    queue.offer(node1.left);
                    child++;
                }
                if (node1.right != null) {
                    queue.offer(node1.right);
                    child++;
                }
            }
            size = child;
        }
    }

    public class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data, TreeNode left, TreeNode right) {
            this.val = data;
            this.left = left;
            this.right = right;
        }

        private TreeNode(int val) {
            this.val = val;
        }
    }


    @Test
    public void tete() {
        // 构建二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        LeftView(root);
    }

    /**
     * 递归时所有的变量都会推到栈中
     */
    @Test
    public void diguiTest() {
        try {
            System.out.println("digui-------------" + digui(""));

        }catch (Exception e){
        }
    }

    private int num = 0;
    private int flag = 2;
    private int i = 0;
    private int getFlag = 0;

    private String digui(String str) {
        String name = "";
        String s;
        do {
            num++;
            if (num == 6) {
                System.out.println("nimmei------------------");
                i = 6;
                return null;
            }
            System.out.println("i-------------------" + i);
            if (num / flag > 1 && num < 10) {
                name = num + "";
                digui(name);
            }
            if (num == 10) {
                num = 0;
            }
            s = name + "---------------";
        } while (num > 0 && i < 2);
        System.out.println(name);
        System.out.println(s);
        return "12";
    }




    @Test
    public void  color(){
        int[] num1 = {1, 2, 3, 7, 8, 9};
        int[] num2 = {2, 5, 6};
        //merge(num1, 3, num2, 3);
        mergeNum(num1, num2, 3, 3);
        for (int i1 : num1) {
            System.out.println(i1);
        }
        //假设num1长度大于m+n
    }

    private void mergeNum(int[] num1, int[] num2, int m, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            num1[p--] = (num1[p1] < num2[p2]) ? num2[p2--] : num1[p1--];
        }
        System.arraycopy(num2, 0, num1, 0, p2 + 1);
    }

    public void sortColors(int[] nums) {
        int a0=0;
        int a2=nums.length-1;
        for (int i = 0; i < nums.length; i++) {
            if (i > a2) {
                break;
            }
            if (nums[i] == 0) {
                int temp = nums[a0];
                nums[a0] = nums[i];
                nums[i] = temp;
                a0++;
            } else if (nums[i] == 2) {
                int temp = nums[a2];
                nums[a2] = nums[i];
                nums[i] = temp;
                a2--;
                i--;
            }
        }

    }





}
