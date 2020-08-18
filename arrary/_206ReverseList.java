class _206ReverseList{
    public static void main(String[] args) {
        // 测试代码就不写了
    }
}
/**
 * 206. 反转链表 https://leetcode-cn.com/problems/reverse-linked-list/

 */
class _206Solution{
    public ListNode reverseList(ListNode head) {
        ListNode curr;
        ListNode pre = null;
        while(head != null) {
            curr = head.next;
            head.next = pre;
            pre = head;
            head = curr;
        }
        return pre;
    }
    
}