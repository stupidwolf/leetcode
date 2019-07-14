package xyz.stupidwolf;

import org.junit.Test;

/**
 * <p>create at <code>2019-06-18</code></p>
 *
 * @author chenmingli
 */
public class BestTimeToBuyAndSellStock_121 {

    @Test
    public void test() {
        int[] prices = new int[] {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit2(prices));

        prices = new int[] {4,3,2,1};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit2(prices));

        prices = new int[] {2, 3, 2, 1, 4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit2(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 0) {
            return 0;
        }
        int profit = 0;
        int lowestPrice = prices[0];

        for (int i = 0; i < prices.length; i ++) {
            if (prices[i] < lowestPrice) {
                lowestPrice = prices[i];
            } else {
                // 当前天卖出所能获取到的最大收益
                profit = Math.max(profit, prices[i] - lowestPrice);
            }
        }
        return profit;
    }

    public int maxProfit2(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int profit = 0;
        int lowestPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            lowestPrice = Math.min(lowestPrice, price);
            profit = Math.max(profit, price - lowestPrice);
        }
        return profit;
    }
}
