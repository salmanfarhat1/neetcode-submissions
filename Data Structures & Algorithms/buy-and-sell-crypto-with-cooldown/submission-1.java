class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer[][] memo = new Integer[n][2];

        return backtrack(prices, 0, 1, memo);
    }

    public int backtrack(int[] prices, int i, int canBuy,
                         Integer[][] memo) {
        if (i >= prices.length)
            return 0;

        if (memo[i][canBuy] != null)
            return memo[i][canBuy];

        int profit;

        if (canBuy == 1) {
            // Buy today or skip today
            int buy = -prices[i] + backtrack(prices, i + 1, 0, memo);
            int skip = backtrack(prices, i + 1, 1, memo);

            profit = Math.max(buy, skip);
        } else {
            // Sell today (cooldown: skip next day) or hold
            int sell = prices[i] + backtrack(prices, i + 2, 1, memo);
            int hold = backtrack(prices, i + 1, 0, memo);

            profit = Math.max(sell, hold);
        }

        memo[i][canBuy] = profit;
        return profit;
    }
}
