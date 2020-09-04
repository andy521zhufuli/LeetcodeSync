public class _007ReverseNumber {
    public static void main(String[] args) {
        int result = reverseWrong(1534236469);
        System.out.println(result);
    }

public static int reverse(int x) {
    int ans = 0;
    while (x != 0) {
        int mod = x % 10;// 求余操作
        // 这里也就知道为什么下面两个判断为什么是7和8了
        if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && mod > 7))
            return 0;
        if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && mod < -8))
            return 0;
        ans = ans * 10 + mod;
        x /= 10;// 整除操作
    }
    return ans;
}

    /**
     * 看下 1534236469 为什么不行
     * @param x
     * @return
     */
    public static int reverseWrong(int x) {
        int ans = 0;
        while (x != 0) {
            int mod = x % 10;
            ans = ans * 10 + mod;
            x = x / 10;
        }
        return ans;
    }
}