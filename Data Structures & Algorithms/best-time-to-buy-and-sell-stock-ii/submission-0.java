class Solution {
    public int maxProfit(int[] prices) {
        /* notes: 
            I assume I buy on each day and sell if there is a profit 
            just add it to the global profit 
            7 1 5 3 
        */ 
        int profit = 0; 
        int sell = prices[0];
        int buy = prices[0]; 
        for(int i =0; i < prices.length; i++){ 
            sell = prices[i];
            int curProfit = sell - buy;  
            if(curProfit > 0){
                profit += curProfit;
                
            }
            buy = sell; 
        }
        return profit;
    }
}