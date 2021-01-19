package www.zx.com.bean;

/**
 * @project:leetcode
 * @packname:www.zx.com.bean
 * @name: ReverseList
 * @describe:
 * @author: zhaoxin
 * @create: 2021-01-19-11:48 AM
 */
public class ReverseList {
    private static ListNode reverse(ListNode listNode) {
        if(listNode==null)
        {
            return null;
        }
        if (listNode.next == null)
        {
            return listNode;
        }
        ListNode head=reverse(listNode.next);
        listNode.next.next=listNode;
        listNode.next=null;
        return head;

    }
   static ListNode tail = null; // 后驱节点
    private static ListNode reverse(ListNode listNode,int n) {
        if(listNode==null)
        {
            return null;
        }
        if(n==1)
        {
            tail=listNode.next;
            return listNode;
        }
        ListNode head=reverse(listNode.next,n-1);
        listNode.next.next=listNode;
        listNode.next=tail;
        return head;

    }

    public static void main(String[] args) {
        ListNode data = new ListNode(0);
        data.next = new ListNode(1);
        data.next.next = new ListNode(2);
        data.next.next.next = new ListNode(3);

        ListNode test=data;
        while (test != null)
        {
            System.out.println(test.val);
            test = test.next;
        }
        ListNode head=reverse(data,3);

        while (head != null)
        {
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println("done");
    }
}
