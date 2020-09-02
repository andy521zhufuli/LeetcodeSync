import java.util.Comparator;
import java.util.PriorityQueue;

class MergeSortedArrays {
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,0,0,0,0,0};
        int[] B = {1,5,7,9};
        MergeSortedArraysSolution solution = new MergeSortedArraysSolution();
        solution.merge(A, 5, B, 4);
    }
}
class MergeSortedArraysSolution{

    // 第一步：既然是排序两个有序的数组，A数组后面还有足够的空间可以塞的下B数组，那我就先把B数组放在A的后面
    // 第二步：剩下的事情就是排序一个非有序的数组，就还原了我们最基本的知识：一个数组的排序
    //        可以用的方法很多：比如快速排序：但是又因为快速排序对基本有序的数组不友好，所以暂时可以放弃这个
    //                       归并排序：这个我不太熟，不太会用，所以就放弃了
    //                       堆排序：这个我这几天正在用，还是比较熟悉的，那就用小顶堆就好了（Java为我们封装好了PriorityQueue，直接拿来用就可以了）
    // 第三步：将小顶堆输出到数组里面，完成排序
    // 分析：时间复杂度：第一步是：O(n)，第二步：O(m+n)*O(log(m+n))，第三步：O(m+n)*O(log(m+n))
    //      空间复杂度：因为我们新建了一个堆，切堆的大小为m+n，所以我们的空间复杂度为
    // 所以综上：时间复杂度为O(m+n)*O(log(m+n))，空间复杂度为：O(m+n)
    public void merge(int[] A, int m, int[] B, int n) {
        // 第一步：把B数组里面的数据移动到A里面，放在A的后面
        for (int i = m; i < A.length && i < m + n; i++) {
            A[i] = B[i-m];
        }

        // 第二步：然后对这个未排序的数组进行排序 两种方法：快速排序（好像不太好，快排对已经有序的不友好），归并排序，堆排序
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(m+n, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (int i = 0; i < m+n; i++) {
            queue.offer(A[i]);
        }

        // 第三步：把Queue里面的已排序的数据输出到A里面，完成排序
        int index = 0;
        while(!queue.isEmpty()) {
            A[index++] = queue.poll();
        }
    }

}