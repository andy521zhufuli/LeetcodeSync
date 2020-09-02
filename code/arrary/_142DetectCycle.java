import java.util.HashSet;
import java.util.Set;

class _142DetectCycle {
    public static void main(String[] args) {

    }
}

/**
 * 142. 环形链表 II https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * 使用一个hashSet来判断有没有环，set不能存放相同的item
 */
class _142DetectCycleSolution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        while(head != null) {
            if(visited.contains(head)) {
                return head;
            }
            visited.add(head);
            head = head.next;
        }
        return null;
    }
}