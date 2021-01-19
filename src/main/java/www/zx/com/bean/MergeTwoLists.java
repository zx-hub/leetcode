package www.zx.com.bean;

/**
 * @project:leetcode
 * @packname:www.zx.com.bean
 * @name: MergeTwoLists
 * @describe:
 * @author: zhaoxin
 * @create: 2021-01-18-4:14 PM
 */
public class MergeTwoLists {
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
        {
            return l1 == null ? l2 : l1;
        }
        ListNode head = new ListNode(0);
        ListNode a = l1, b = l2, tail = head;
        while (a != null && b != null)
        {
            if (a.val < b.val)
            {
                tail.next = a;
                a = a.next;
            } else
            {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        tail.next = (a == null ? b : a);
        return head.next;
    }

    public static void main (String[] args)
    {
        ListNode a=new ListNode(1);
        a.next=new ListNode(2);
        a.next.next=new ListNode(4);
        ListNode b=new ListNode(1);
        b.next=new ListNode(3);
        b.next.next=new ListNode(4);
        ListNode sys=mergeTwoLists(a,b);
        System.out.println(sys);
        while (sys.next!=null)
        {
            System.out.println(sys.val);
            sys=sys.next;
        }
        System.out.println("done");
    }
}
