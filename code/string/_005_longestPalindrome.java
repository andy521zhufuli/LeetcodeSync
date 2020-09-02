
/**
 * 最长回文子串
 */
public class _005_longestPalindrome {
    public static void main(String[] args) {
        String result = longestPalindrome("abcbaac");
        System.out.print(result);
    }

    public static String longestPalindrome(String s) {
        String result = "";
        int max = 0;
        int len = s.length();
        // 两重循环求所有子串，这里复杂度是O(n^2)
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String sub = s.substring(i, j);
                // 找出最长的回文子串 这里复杂度是O(n)
                if (isPalindromic(sub) && sub.length() > max) {
                    result = s.substring(i, j);
                    max = Math.max(max, result.length());
                }
            }
        }
        return result;
    }

    // 计算当前子串是不是回文串
    public static boolean isPalindromic(String s) {
        int len = s.length();
        // 这里奇偶都一样
        for (int i = 0; i < len / 2; i++) {
            // 左右指针，从两边往中间依次遍历，判断是否相等
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }


    public static String longestPalindromeOpt(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = isPalindromicOpt(s, i, i);// 对奇数位判断
            int len2 = isPalindromicOpt(s, i, i + 1);// 对偶数位判断
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    
    private static int isPalindromicOpt(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}