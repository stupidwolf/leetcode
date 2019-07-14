package xyz.stupidwolf;

/**
 * <p>create at <code>2019-06-18</code></p>
 *
 * @author chenmingli
 */
public class BestTimeToBuyAndSellStockII_122 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int profit = 0;
        int i = 0;
        int begin;
        int end;
        while (i < prices.length) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i ++;
            }
            begin = i;

            end = begin;
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i ++;
            }
            profit += prices[end] - prices[begin];
            i ++;
        }

        return profit;
    }
}
