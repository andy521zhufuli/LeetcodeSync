import java.util.Comparator;
import java.util.PriorityQueue;

class FindKthLargest {
    public static void main(String[] args) {
        
    }
}
/**
 * 215. 数组中的第K个最大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * 使用小顶堆实现，堆定元素就是第K大的元素了
 * 堆：插入一次元素为logK
 * 快速排序：NlogN
 */
class FindKthLargestSolution{
    public int findKthLargest(int[] nums, int k) {
        // 创建一个小顶堆  其实默认就是小顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(11, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
        }); 
        
        for (int i = 0; i < nums.length; i++) {
            heap.offer(nums[i]);
            if(heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }
}