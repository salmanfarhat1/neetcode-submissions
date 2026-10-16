class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length - 1; 
        int[] dp = new int[ cost.length + 2 ];
        for(int i = n; i >= 0; i--){
            dp[i] = cost[i] +  Math.min(dp[i + 1],  dp[i + 2]); 
        } 
        return Math.min(dp[0], dp[1]);
    }
}
