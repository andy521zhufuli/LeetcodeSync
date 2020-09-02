import java.util.Arrays;

class LongestConsecutive {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        SolutionConsecutive consecutive = new SolutionConsecutive();
        System.out.println(consecutive.longestConsecutive(nums)+"");
    }
}
/**
 * 128. 最长连续序列
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 * 
 * 思路就是前一个挨着跟后面一个比较，找出最长的后一个大于前一个1的序列
 * 然后优化一点的思路就是：先排序再找
 *
 * 再优化一点：就是不排序，然后用hashSet去找  这样查找的时间复杂度就是1
 */

class SolutionConsecutive {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int longestStreak = 1;
        int currentStreak = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                if (nums[i] == nums[i-1]+1) {
                    currentStreak += 1;
                }
                else {
                    longestStreak = Math.max(longestStreak, currentStreak);
                    currentStreak = 1;
                }
            }
        }

        return Math.max(longestStreak, currentStreak);
    }
}

