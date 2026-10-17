class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0')
            return 0; 
        int n = s.length(); 
        int[] dp = new int[n + 1];
        dp[n] = 1; 
        dp[n-1] = 1;
        for(int i = n - 2; i >= 0; i--){
            if(s.charAt(i) == '0'){
                continue; 
            }
            int num = Integer.parseInt(s.substring( i , i + 2)); 

            dp[i] = dp[i + 1]; 

            if(num >= 10 && num <= 26){
                dp[i] += dp[i + 2]; 
            }
        } 
        return dp[0]; 
    }
}

/* Notes: 
    1201234
    4 1 
    34 1        (34)
    234 1 + 1  (2 3 4 | 23 4 )
    1234   2 + 1. (1 2 3 4 | 1 23 4 | 12 3 4  )
    01234 0 
    201234 (20 1 2 3 4 |20 1 23 4 |20 12 3 4 )
    1201234 (1 20 1 2 3 4 |1 20 1 23 4 |1 20 12 3 4 )
*/ 
