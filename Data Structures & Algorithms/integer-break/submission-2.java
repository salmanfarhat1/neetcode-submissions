class Solution {
    // int max = Integer.MIN_VALUE;
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
         
        if(n == 2)
            return 1; 
        return backtrack(n, dp); 
     
    }

    public int backtrack(int n, int[] dp){
        if(n < 2){
            return 1;
        }
        if(dp[n] != 0)
            return dp[n]; 
        
        int max = 0;
        for(int i = 2; i <= n ; i++){
            max = Math.max(max, i * backtrack(n - i, dp));
        }
        dp[n] = max; 
        return max; 
    }
}