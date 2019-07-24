package xyz.stupidwolf;

import org.junit.Test;

public class Minimum_Path_Sum_64 {

    @Test
    public void test() {
        int[][] grid = new int[][] {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };

        System.out.println(minPathSum(grid));
    }
    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];

        dp[0][0] = grid[0][0];

        for (int i = 1; i < grid[0].length; i ++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < grid.length; i ++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < grid.length; i ++) {
            for (int j = 1; j < grid[i].length; j ++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}
