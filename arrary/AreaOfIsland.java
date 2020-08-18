import java.util.Stack;

/**
 * 695. 岛屿的最大面积 官方题解：深度优先搜索DFS(迭代)，使用栈去代替递归
 * https://leetcode-cn.com/problems/max-area-of-island/solution/dao-yu-de-zui-da-mian-ji-by-leetcode/
 */
class AreaOfIsland {

    public static void main(String[] args) {
        int[][] grid1  = 
        {
            {0,1,0,1,0},
            {0,1,1,1,0},
            {0,0,0,1,0},
            {1,1,1,0,0}
        };
        Solution11.maxAreaOfIsland(grid1);
    }

    
}

class Solution11 {
    // DFS 迭代解法
    public static int maxAreaOfIsland(int[][] grid) {
        int[] rowDirections = new int[]{1, -1, 0, 0};
        int[] colDirections = new int[]{0, 0, 1, -1};

        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int ans = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                // 只计算元素值等于 1 的面积
                if (grid[row][col] == 1 && !seen[row][col]) {
                    // 存储当前岛屿的面积
                    int area = 0;
                    // 深度优先计算当前岛屿的面积
                    Stack<int[]> stack = new Stack<>();
                    stack.push(new int[]{row, col});
                    // 标识当前的元素已经被访问
                    seen[row][col] = true;
                    while (!stack.isEmpty()) {
                        int[] node = stack.pop();
                        // 遍历的当前元素的行和列
                        int r = node[0];
                        int c = node[1];

                        // 面积 +1
                        area++;

                        // 依次从当前元素的前后左右四个方向来遍历
                        for (int i = 0; i < 4; i++) {
                            int nr = r + rowDirections[i];
                            int nc = c + colDirections[i];
                            // 如果当前方向上的元素满足条件，即属于连续岛屿的一部分
                            if (nr >= 0 && nr < grid.length
                                    && nc >= 0 && nc < grid[0].length
                                    && grid[nr][nc] == 1 && !seen[nr][nc]) {
                                // 那么深度优先搜索这个方向的节点
                                stack.push(new int[]{nr, nc});
                                seen[nr][nc] = true;
                            }
                        }
                    }
                    ans = Math.max(ans, area);
                }
            }
        }
        return ans;
    }

}

