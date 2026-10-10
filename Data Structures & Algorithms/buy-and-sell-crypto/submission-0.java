class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0; 
        int buyAt = prices[0]; 
        for(int i =0; i < prices.length; i++){
            buyAt = Math.min(buyAt, prices[i]);
            maxProfit = Math.max(prices[i] - buyAt, maxProfit);  
        }
        return maxProfit; 
    }
}
