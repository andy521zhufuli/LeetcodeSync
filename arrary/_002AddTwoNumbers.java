class _002AddTwoNumbers {
    public static void main(String[] args) {
        _002AddTwoNumbersSolution s = new _002AddTwoNumbersSolution();
        s.test();
    }
}

/**
 * 2. 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 * 题目比较简单，链表从左到右依次是个位十位百位，然后按照普通的数学加法，记住进位就可以了
 */
class _002AddTwoNumbersSolution {

    public void test() {
        ListNode node = new ListNode(1);
        // node.next = new ListNode(4);
        // node.next.next = new ListNode(3);

        ListNode node2 = new ListNode(9);
        node2.next = new ListNode(9);
        // node2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(node, node2);
        ListNode ss = result;
    }
    


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        int carry = 0;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode curr = newHead;
        while(p1 != null || p2 != null) {
            int val1 = p1 != null ? p1.val : 0;
            int val2 = p2 != null ? p2.val : 0;
            int sum = ((val1 + val2)  + (carry > 0 ? carry : 0)) % 10;
            carry = ((val1 + val2)  + (carry > 0 ? carry : 0)) / 10;
            curr.next = new ListNode(sum);
            curr = curr.next;
            if(p1 != null)
                p1 = p1.next;
            if(p2 != null)
                p2 = p2.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return newHead.next;
    }
}