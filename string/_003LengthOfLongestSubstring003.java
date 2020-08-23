import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 无重复字符的最长子串 LeetCode003
 */
class _003LengthOfLongestSubstring003 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcacbaa"));
    }

    /**
     * 暴力解法
     * 
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int len = 0;

        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {

            return 1;
        }

        int firstPoint = 0;
        int nextPoint = 0;

        boolean[] exist = new boolean[255];

        while (nextPoint < s.length() && firstPoint < s.length()) {

            int currMax = 0;
            int index = s.charAt(nextPoint) - 0;
            while (exist[index] == false && nextPoint < s.length()) {
                exist[s.charAt(nextPoint) - 0] = true;
                nextPoint++;
                if (nextPoint < s.length()) {
                    index = s.charAt(nextPoint) - 0;
                }

            }

            currMax = Math.max(currMax, nextPoint - firstPoint);
            firstPoint++;
            nextPoint = firstPoint;
            len = Math.max(len, currMax);
            for (int i = 0; i < 255; i++) {
                exist[i] = false;
            }

        }

        return len;
    }

    /**
     * 滑动窗口
     * 
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringSlideWindow(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));// 这里是精髓 只删除最左边的，比如abc,后面一个是c，那么这里就会一直删除，知道abc全被删除，最后走上面的if，把c添加进去，这就是滑动窗口的精髓
            }
        }
        return ans;
    }

    /**
     * 优化了的滑动窗口
     * 
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringOptSlideWindow(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}