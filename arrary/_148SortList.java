import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import com.apple.concurrent.Dispatch.Priority;

class _148SortList{
    public static void main(String[] args) {

        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(3);
        _148SortListSolotion solotion = new  _148SortListSolotion();
        ListNode node = solotion.sortList(listNode);
        ListNode n1= node;

    }
}

/**
 * 148. 排序链表 https://leetcode-cn.com/problems/sort-list/
 * 要求是nlogn的时间复杂度，空间复杂读控制在O(1),用归并算法可以实现，但是我不会，所以我用了简单的堆排序算法
 */
class _148SortListSolotion {
    public ListNode sortList(ListNode head) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(11, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1 - o2;
			}
        });
        while(head != null) {
            queue.offer(head.val);
            head = head.next;
        }

        ListNode newHead = new ListNode(-1);
        ListNode result = newHead;
        while(!queue.isEmpty()) {
            result.next = new ListNode(queue.poll());
            result = result.next;
        }
        return newHead.next;
    }
}