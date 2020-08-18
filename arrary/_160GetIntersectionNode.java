import java.util.HashSet;
import java.util.Set;

class _160GetIntersectionNode {
    public static void main(String[] args) {
        
    }
}
/**
 * 160. 相交链表 https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * 使用最简单的方法，时间复杂度O(M+N)，使用一个set存放其中一个list的节点，然后遍历另一个list，判断节点是否在set中
 */
class _160GetIntersectionNodeSolution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while(headB != null) {
            set.add(headB);
            headB = headB.next;
        }
        while(headA != null) {
            if(set.contains(headA)) {
                return headA;
            }
            headA = headA.next;
        }
        return null;
    }
}