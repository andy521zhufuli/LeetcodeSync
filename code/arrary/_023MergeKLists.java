import java.util.Comparator;
import java.util.PriorityQueue;

class _023MergeKLists {
    public static void main(String[] args) {
        
    }
}

/**
 * 23. 合并K个排序链表 https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
class _023MergeKListsSolution {
    /**
     * 21题是合并2个有序链表，这个是合并多个，把这个拆解拆解开来不就行了吗？
                        口   口  口   口  口   口  口    口  
                        \    /   \   /   \   /    \   /
                        口       口       口      口
                        \      /         \      /
                            口                口
                            \               /
                                    口
        大概是上面这个样子，应该是属于分治法，但是我写不出来代码，惭愧啊
     * @param lists
     * @return
     */
    public ListNode mergeKListsDivide(ListNode[] lists) {
        _21MergeTwoListsSolutin two = new _21MergeTwoListsSolutin();
        for (int i = 0; i < lists.length; i++) {
            
        }
        return null;
    }

    /**
     * 使用额外空间去解决，使用优先队列，就是小顶堆
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(11, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
        });
        
        for (int i = 0; i < lists.length; i++) {
            ListNode item = lists[i];
            while(item != null) {
                queue.offer(item.val);
                item = item.next;
            }
        }

        ListNode result = new ListNode(-1);
        ListNode head = result;
        while(!queue.isEmpty()) {
            head.next = new ListNode(queue.poll());
            head = head.next;
        }
        return result.next;
    }

    
}