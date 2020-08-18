import java.util.Comparator;
import java.util.PriorityQueue;

class FindLengthOfLCIS {
    public static void main(String[] args) {
        FindLengthOfLCISSoluition soluition = new FindLengthOfLCISSoluition();
        int[] nums = {1,3,5,4,7};
        int res = soluition.findLengthOfLCIS(nums);
        System.out.println(res + "");
    }
}


/**
 * https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 * 674. 最长连续递增序列
 * 解法：前后对比，一次遍历解决问问题
 */
class FindLengthOfLCISSoluition {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length <= 1) {
            return nums.length;
        }
        int ans = 1;
        int count = 1;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] < nums[i+1]) {
                count++;
            }else {
                count = 1;
            }
            ans = count > ans ? count : ans;
        } 
        return ans;
    }

}

