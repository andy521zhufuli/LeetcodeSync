import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
class ThreeSum{
    public static void main(String[] args) {
        Solution solution = new Solution();
                  //" -4, -1, -1, 0,  1,  2"
        int[] nums = {-1,  0,  1, 2, -1, -4};
        List<List<Integer>> result = solution.threeSum(nums);
    }

}


/*
分析：这个题的重点在于 第一 找到和为零三元组 第二三元组不能有重复
1.首先 我们来找 和为零的三元组 
1）三重循环可以找到 我们要的 三个数（即 第一重循环 找到第一个数 第二重循环 找到第二数 第三重循环 找到第三个数）
2）若元组排了顺序（小到大） 我们可以用 二重循环 解决 第一重循环 找一个数 
    第二重循环 找第二个和第三个 一个由小到大-> 一个由大到小<- 知道相遇。
    当 和>0 时 说明 数应该变小 第三个减小 和<0 时 数应该变大 第二个增大。

2.找到了三元组  使其不重复
1）首先 组内的是有 顺序的 （1，2，3） （3，2，1）要先排序，再做的
2）遍历 有相同的（这里指的equals） 删除

3)可以重复造轮子 HashSet 了解一下 或者 HashMap 了解一下
  HashSet Set 集合是无序（指的是不按照你添加的 顺序 而是 内置的顺序）不可以重复的的（ （1，2，2）->(1,2)）
  HashMap 的 key 是唯一的 也可以了解一下 

*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> result = new ArrayList<>();
        HashSet<List<Integer>> hashSet = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] >  0) break;

            int low = i + 1;
            int high = nums.length - 1;

            while (low < high) {
                if (nums[low] + nums[high] + nums[i] == 0) {
                    if (!hashSet.contains(Arrays.asList(nums[i], nums[low], nums[high]))) {
                        hashSet.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    }



                    low++;
                    high--;
                } else if (nums[low] + nums[high] + nums[i] > 0 ) {
                    high--;
                } else {
                    low++;
                }

            }
        }

        return result;
    }
    
    
}