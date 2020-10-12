package demo;

public class E16ReverseList {

    private ListNode ReverseList(ListNode head){
        if(head == null)
            return null;
        ListNode preListNode = null;
        ListNode nowListNode = head;

        while(nowListNode != null){
            //1,保存下一个结点  2,当前结点指向前一个结点 3,前任结点 到现任节点 4,现任节点到下一结点
            ListNode nextNode = nowListNode.next;
            nowListNode.next = preListNode;
            preListNode = nowListNode;
            nowListNode = nextNode;

        }
        return preListNode;
    }
    public static void main(String[] args){
        //System.out.println(result.data);
    }

}
