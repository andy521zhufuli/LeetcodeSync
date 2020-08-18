class DynamicProgramming {
    public static void main(String[] args) {
        int[][] apple = { 
            { 5, 1, 7, 1, 2 }, 
            { 4, 1, 1, 1, 3 }, 
            { 3, 2, 6, 1, 3 }, 
            { 1, 1, 1, 0, 2 } 
        };
        SolutionNormalDP normalDP = new SolutionNormalDP();
        int res = normalDP.maxApple(apple, 4, 5);
    }
}

/**
 * 121. 买卖股票的最佳时机
 * 可以参考这个题解：详细分析了每个状态以及状态之间的转换方程
 *                https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/bao-li-mei-ju-dong-tai-gui-hua-chai-fen-si-xiang-b/
 */
class SolutionMaxProfit {
    
}

/**
 * 普通DP问题 Java-动态规划-最多苹果数量的方法
 * https://blog.csdn.net/pilihaotian/article/details/77477367
 */
class SolutionNormalDP {
    

    public int maxApple(int apple[][], int M, int N) {
        int[][] dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = apple[i][j];
                    continue;
                }
                if(i == 0) {
                    dp[i][j] = dp[i][j-1] + apple[i][j];
                    continue;
                }

                if(j == 0) {
                    dp[i][j] = dp[i-1][j] + apple[i][j];
                    continue;
                }

                if(dp[i-1][j] > dp[i][j-1]) {
                    dp[i][j] = dp[i-1][j] + apple[i][j];
                }else {
                    dp[i][j] = dp[i][j-1] + apple[i][j];
                }
            }
        }
        return dp[M-1][N-1];
    }

}