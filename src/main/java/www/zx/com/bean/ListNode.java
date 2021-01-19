package www.zx.com.bean;

/**
 * @project:leetcode
 * @packname:www.zx.com.model
 * @name: ListNode
 * @describe:
 * @author: zhaoxin
 * @create: 2021-01-18-4:01 PM
 */
public class ListNode {
    //节点个数
    private int size;
    int val;
     ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

