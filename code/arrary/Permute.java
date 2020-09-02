import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Permute {
    public static void main(final String[] args) {
        final SolutionPermute sPermute = new SolutionPermute();
        long start = System.currentTimeMillis();
        sPermute.getPermutation(9, 200000);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

/**
 * 46：全排列
 * 这个人的解法很棒：https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
 */

/**
 * 9 和 161191执行超时了
 */
class SolutionPermute {
    // 思路是：先全排列，找出所有的可能，然后在list里面找到这个位置
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];   
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        List<List<Integer>> list = permute(nums);
        if(k>list.size()) {
            return "";
        }
        List<Integer> res = list.get(k-1);
        String result = "";
        for(int i = 0; i < res.size(); i++) {
            result += res.get(i);
        }
        return result;
    }

    public void test() {
        final int[] nums = { 1, 2, 3 };

        final List<List<Integer>> lists = permute(nums);
        System.out.println(lists);

    
    }

    int n;
    Stack<Integer> path;
    List<List<Integer>> res;
    boolean[] state;

    public List<List<Integer>> permute(final int[] nums) {
        n = nums.length;
        if (n <= 0)
            return res;

        state = new boolean[n];
        path = new Stack<Integer>();
        res = new ArrayList<>();

        dfs(nums, 0);
        return res;
    }

    public void dfs(final int[] nums, final int depth) {
        if (depth == n) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!state[i]) {
                // 保存现场
                state[i] = true;
                path.push(nums[i]);

                dfs(nums, depth + 1);

                // 恢复现场
                path.pop();
                state[i] = false;
            }
        }
    }

}