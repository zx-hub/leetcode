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

    static ListNode tail = null; // 后驱节点

    //整体反转
    //压栈,找到最后一个节点，然后锁定最后一个节点为head,出栈时指向互换。
    private static ListNode reverse(ListNode listNode) {
        if (listNode == null)
        {
            return null;
        }
        if (listNode.next == null)
        {
            return listNode;
        }
        ListNode head = reverse(listNode.next);
        listNode.next.next = listNode;
        listNode.next = null;
        return head;
    }

    private static ListNode reverse2(ListNode listNode) {
        if (listNode == null)
        {
            return null;
        }
        ListNode pre = null;
        ListNode cur = listNode;
        ListNode nxt = null;
        while (cur != null)
        {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    //整体反转
    //压栈,找到最后一个节点，然后锁定最后一个节点为head,出栈时指向互换。
    private static ListNode reverse(ListNode a, ListNode b) {
        if (a == null)
        {
            return a;
        }
        ListNode pre = null;
        ListNode cur = a;
        ListNode nxt = null;
        while (cur != b)
        {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    //前N个反转
    //借助reverse,规划为长度为n的链表反转，多余的部分先记下为tail,反转后接上tail
    private static ListNode reverseN(ListNode listNode, int n) {
        if (listNode == null)
        {
            return null;
        }
        //找到n节点的位置,记下后续多余，即可反转
        if (n == 1)
        {
            tail = listNode.next;
            return listNode;
        }
        ListNode head = reverseN(listNode.next, n - 1);
        listNode.next.next = listNode;
        listNode.next = tail;
        return head;
    }

    //指定范围反转
    //规划为1,x的reverseN反转,需要接上原来的头即可。接入点即为m=1的时候。去除特例m=1,listNode依次接上反转部分即可
    private static ListNode reverseBetween(ListNode listNode, int m, int n) {
        if (listNode == null)
        {
            return null;
        }
        if (m == 1)
        {
            return reverseN(listNode, n);
        }
        listNode.next = reverseBetween(listNode.next, m - 1, n - 1);
        return listNode;
    }

    //k个一组反转
    //首先特例是剩余个数不足k个时候就不反转了。先列出特例
    private static ListNode reverseGroup(ListNode listNode, int k) {
        if (listNode == null || k < 2)
        {
            return listNode;
        }
        ListNode b = listNode;
        //不足时不在反转
        for (int i = 0; i < k; i++)
        {
            if (listNode.next == null)
            {
                return listNode;
            }
            b = b.next;
        }
        ListNode head = reverse(listNode, b);
        listNode.next = reverseGroup(b, k);
        return head;
    }

    public static void main(String[] args) {
        ListNode data = new ListNode(0);
        data.next = new ListNode(1);
        data.next.next = new ListNode(2);
        data.next.next.next = new ListNode(3);
        data.next.next.next.next = new ListNode(4);
        ListNode node5 = new ListNode(5);
        data.next.next.next.next.next = node5;
        node5.next = new ListNode(6);
        node5.next.next = new ListNode(7);
        node5.next.next.next = new ListNode(8);
        node5.next.next.next.next = new ListNode(9);

        ListNode test = data;
        //while (test != null)
        //{
        //    System.out.println(test.val);
        //    test = test.next;
        //}
        //ListNode head = reverseBetween(data, 3, 4);

        ListNode head = reverseGroup(data, 3);
        //ListNode head=reverse(data,node5);
        while (head != null)
        {
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println("done");
    }
}
