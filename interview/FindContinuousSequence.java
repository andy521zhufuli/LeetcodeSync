import java.util.ArrayList;
import java.util.List;

class FindContinuousSequence{
    public static void main(String[] args) {
        
    }
}

/**
 * 面试题57 - II. 和为s的连续正数序列  https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 * 使用滑动窗口的方案，双指针
 * 这个题解很好的介绍了什么是双指针，讲的很不错：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solution/shi-yao-shi-hua-dong-chuang-kou-yi-ji-ru-he-yong-h/
 */
class FindContinuousSequenceSolution{
    public int[][] findContinuousSequence(int target) {
        int i = 1;
        int j = 1;
        int sum = 0;
        List<int[]> res = new ArrayList<>();
        while(i <= target / 2) {
            if (sum < target) {
                // 右边界向右移动
                sum += j;
                j++;
            }else if (sum > target) {
                // 左边界向右移动
                sum -=i;
                i++;
            }else {
                // 找到了等于target的连续序列
                int[] arr = new int[j - i];
                for (int k = i; k < j; k++) {
                    arr[k - i] = k;
                }
                res.add(arr);
                // 左边界可以向右移动了
                sum -= i;
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}