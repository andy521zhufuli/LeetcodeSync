class _Fib {
    public static void main(String[] args) {
        
        int result = fib1(8);
        System.out.println("原始递归" + result);

        FibSolution fibSolution = new FibSolution();
        fibSolution.fibCache();
    }

    private static int fib1(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib1(n-1) + fib1(n-2);
    }


}
/**
 * 优化的  使用数组缓存起来
 */
class FibSolution {
    int[] cache = new int[300];
    public void fibCache() {
        System.out.println("优化递归" + fib2(200));
        fibDP(200);
    }

    private int fib2(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if(cache[n] > 0) {
            return cache[n];
        }
        cache[n] = fib2(n-1) + fib2(n-2);
        return cache[n];
    }

    /**
     * 动态规划的斐波那契数列
     * @param n
     */
    private void fibDP(int n) {
        int[] result = new int[n];
        result[0] = 1;
        result[1] = 1;
        for (int i = 2; i < n; i++) {
            result[i] = result[i-1] + result[i-2];
        }
        System.out.println("DP" + result[n-1]);
    }
}