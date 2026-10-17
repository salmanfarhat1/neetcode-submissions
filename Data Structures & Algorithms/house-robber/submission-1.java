class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 2]; 
        for(int i = nums.length - 1; i >= 0 ; i--){
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i +1]);
        } 
        return dp[0];
    }
}


/* Notes: 

[1, 1, 3, 3]

[3] -> 3
[ , 15, 14, 6, 6, 0]

dp[i] = max(nums[i] + dp[i + 2], dp[i + 1 ]) 

the equation is: dp[]
do I rob here or I take the one infront

*/ 
