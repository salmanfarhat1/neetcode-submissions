class Solution {
    public int climbStairs(int n){
        if(n == 0 || n == 1 || n == 2)  return n; 

        int[] dp = new int[n + 1];
        dp[0] = 0; 
        dp[1] = 1; 
        dp[2] = 2; 
        for(int i = 3 ; i < n + 1; i++){
            dp[i] = dp[i - 1] + dp[i - 2]; 
        }
        return dp[n]; 
    }
}



/* Notes: 
    skip or take is of complexity
    each time I have 2 choices 
    and we have n stairs 
    so it will be 2 power n max O( ) 

    can we do better ? 

    if we have 1 stair it is only 1 step 

    if we have 2 stairs it is what ? 

    5
    [ , , , 2, 1] 

    1 

for n = 2
    1 1 add 2 
    2

for n = 3 
    1 1 1  add 1 
    2 1  
    1 2

for n = 4 
    1 1 1 ->  1 1 1 1 - 1 1 2  
    2 1   ->  2 1 1 - 2 2
    1 2   ->  1 2 1
    


*/
