package xyz.stupidwolf;

import org.junit.Test;

/**
 * <p>create at <code>2019-07-01</code></p>
 *
 * @author chenmingli
 */
public class UniquePaths_62 {
    @Test
    public void test() {
        int m;
        int n;
        m = 7;
        n = 3;
        System.out.println(uniquePaths(m, n));
        System.out.println(uniquePaths2(m, n));
    }

    public int uniquePaths(int m, int n) {
        int[] res = new int[]{0};
        backTrace(res, 1, 1, m, n);
        return res[0];
    }

    private void backTrace(int[] res, int row, int col, int m, int n) {
        if (row > n || col > m) {
            return;
        }
        if (row == n && col == m) {
            res[0] ++;
            return;
        }
        backTrace(res, row + 1, col, m, n);
        backTrace(res, row, col + 1, m, n);
    }


    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[1][1] = 1;
        for (int i = 1; i <= m; i ++) {
            for (int j = 1; j <= n; j ++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }

    public int uniquePaths3(int m, int n) {
        int sum = 1;
        int a = 0;
        int b = 0;
        for (int i = 1; i <= m; i ++) {
            for (int j = 1; j <= n; j ++) {
                if (i == 1 && j == 1) {
                    sum = a = b = 1;
                } else {

                    sum += a + b;
                }
            }
        }
        return 0;
    }

    @Test
    public void ttt() {
        System.out.println(0.1f + 0.2f);
//        0.30000000000000004
//        0.30000000000000004
//        0.30000000000000004
    }
}
