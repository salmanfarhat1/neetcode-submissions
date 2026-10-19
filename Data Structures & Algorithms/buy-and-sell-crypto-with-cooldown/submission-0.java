class Solution {
    public int maxProfit(int[] prices) {
        return backtrack(prices, 0);
    }

    public int backtrack(int[] prices, int index) {
        if (index >= prices.length)
            return 0;

        int maxProfit = 0;

        for (int i = index + 1; i < prices.length; i++) {
            int profit = prices[i] - prices[index];

            if (profit > 0) {
                profit += backtrack(prices, i + 2);
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        maxProfit = Math.max(maxProfit, backtrack(prices, index + 1));

        return maxProfit;
    }
}