package leetCode;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            int current = prices[i];
            int prev = prices[i - 1];

            if (current < prev) {
                min = Math.min(min, current);
            }

            profit = Math.max(profit, prev - min);
        }

        return profit;
    }
}
