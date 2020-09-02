import java.util.Arrays;

public class DynamicProgramming1 {
    public static void main(String[] args) {

        SolutionMaxProfit1 profit = new SolutionMaxProfit1();
        int[] prices = {1,2,3,9};
        int result = profit.maxProfit(prices);

        NumberTower tower = new NumberTower();
        tower.solution();

        int[][] apple = { 
            { 5, 1, 7, 1, 2 }, 
            { 4, 1, 1, 1, 3 }, 
            { 3, 2, 6, 1, 3 }, 
            { 1, 1, 1, 0, 2 } 
        };
        SolutionNormalDP1 normalDP = new SolutionNormalDP1();
        int res = normalDP.maxApple(apple, 4, 5);
    }
}

/**
 * 121. 买卖股票的最佳时机
 */
class SolutionMaxProfit1 {
    /**
     * opt(i) 表示前i天获得的最大利润
     * opt(i) = max{opt(i- 1), price[i-1] - price[i]} // 
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices.length<2){
          return 0;
      }
      /**递归方程：
       * m(i)：前i天所能获得的最大利润
       m(i)=max{m(i-1),第i天的价格-前i-1天的最小价格}.....一维的，备忘录m是一维数组
       * */
      int min_price_day=prices[0];
      int [] m=new int[prices.length];
      m[0]=0;//前1天买彩票必是0
      for(int i=1;i<prices.length;i++){
          if(prices[i]<min_price_day){
              min_price_day=prices[i];
          }
          if(prices[i]-min_price_day>m[i-1]){
              m[i]=prices[i]-min_price_day;
          }else{
              m[i]=m[i-1];
          }

      }

      return m[m.length-1];

    }
}


class NumberTower {
    int data[][] = {
        {9,0,0,0,0},
        {12,15,0,0,0},
        {10,6,8,0,0},
        {2,18,9,5,0},
        {19,7,10,4,16}
    };
    public void solution() {
        int row = data.length;
        int column = data[0].length;

        int[][] dp = new int[row][column];
        dp[0][0] = data[0][0];
        dp[1][0] = 9+12;
        dp[1][1] = 9+15;
        for (int i = 1; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                if(j == 0) {
                    dp[i][j] = dp[i-1][j] + data[i][j];
                }else{
                    int a = dp[i-1][j] + data[i][j];
                    int b = dp[i-1][j-1] + data[i][j];
                    dp[i][j] = Math.max(a, b);
                }
            }
        }
        // 这里需要对dp[row-1]进行排序，然后输出最大值，就是我们要求的解
        // 
        Arrays.sort(dp[row-1]);
        System.out.println("结果"+dp[row-1][column-1]);
    }
}


/**
 * 有一头母牛，它每年年初生一头小母牛。每头小母牛从第四个年头开始，每年年初也生一头小母牛。请编程实现在第n年的时候，共有多少头母牛？
 * http://acm.hdu.edu.cn/showproblem.php?pid=2018
 */
class CowProblem {

}

/**
 * 普通DP问题 Java-动态规划-最多苹果数量的方法
 * https://blog.csdn.net/pilihaotian/article/details/77477367
 */
class SolutionNormalDP1 {
    

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