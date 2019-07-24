package xyz.stupidwolf;

import org.junit.Test;

public class EditDistance_72 {

    @Test
    public void test() {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] cost = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i ++) {
            cost[i][0] = i;
        }

        for (int i = 0; i <= n; i ++) {
            cost[0][i] = i;
        }

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    cost[i + 1][j + 1] = cost[i][j];
                } else {
                    // insert
                    int a = cost[i + 1][j];
                    // del
                    int b = cost[i][j + 1];
                    // replace
                    int c = cost[i][j];
                    cost[i + 1][j + 1] = Math.min(Math.min(a, b), c) + 1;
                }
            }
        }

        return cost[m][n];
    }
}
