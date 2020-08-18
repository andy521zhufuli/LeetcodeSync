class _21MergeTwoLists {
    public static void main(String[] args) {
        _21MergeTwoListsSolutin solutin = new _21MergeTwoListsSolutin();

    }
}
/**
 * 21. 合并两个有序链表 :https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
class _21MergeTwoListsSolutin {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            }else{
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 ==null ? l2 : l1;
        return preHead.next;

    }
}
class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
    }
}