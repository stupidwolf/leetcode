package xyz.stupidwolf;

import org.junit.Test;

/**
 * <p>create at <code>2019-06-18</code></p>
 *
 * @author chenmingli
 */
public class BestTimeToBuyAndSellStockIII_123 {

    @Test
    public void test() {
        int[] prices = new int[] {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(prices));

        prices = new int[] {1, 2, 3, 3, 4, 5};
        System.out.println(maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        int start = 0;
        int end = 0;
        int i = 0;
        int firstMax = 0;
        int secondMax = 0;

        while (i < prices.length) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i ++;
            }
            start = i;

            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i ++;
            }
            end = i;

            profit = prices[end] - prices[start];
            if (profit >= firstMax) {
                secondMax = firstMax;
                firstMax = profit;
            } else if (profit > secondMax) {
                secondMax = profit;
            }
            i ++;
        }

        return firstMax + secondMax;
    }
}
