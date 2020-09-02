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
    ListNode newHead = new ListNode(0);// 申请一个新的链表存储计算的结果
    int carry = 0;// 1️⃣表示进位，当退出循环的时候也要考虑进位，很多面试者容易忽略这一点
    ListNode p1 = l1;
    ListNode p2 = l2;
    ListNode curr = newHead;// 2️⃣不能对newHead直接操作，因为我们最后是要返回这个newHead的，所以要有一个新的指针指向它
    while(p1 != null || p2 != null) {
        int val1 = p1 != null ? p1.val : 0;
        int val2 = p2 != null ? p2.val : 0;
        // 3️⃣ 这里其实就是小学数学加法的只是，考虑进位就行了，没啥好说的
        int sum = ((val1 + val2)  + (carry > 0 ? carry : 0)) % 10;
        carry = ((val1 + val2)  + (carry > 0 ? carry : 0)) / 10;
        curr.next = new ListNode(sum);
        curr = curr.next;// 4️⃣考察链表的基本操作
        if(p1 != null)
            p1 = p1.next;
        if(p2 != null)
            p2 = p2.next;
    }
    // 5️⃣循环结束后也要考虑进位
    if (carry > 0) {
        curr.next = new ListNode(carry);
    }
    // 6️⃣这里就能体会到2️⃣的作用了
    return newHead.next;
}
}