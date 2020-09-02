public class _007ReverseNumber {
    public static void main(String[] args) {
        reverse((short) 32767);
    }

    public static int reverse(short x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ans > Short.MAX_VALUE / 10 || (ans == Short.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (ans < Short.MIN_VALUE / 10 || (ans == Short.MIN_VALUE / 10 && pop < -8))
                return 0;
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }
}