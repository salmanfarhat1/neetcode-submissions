class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0')
            return 0; 
        int n = s.length(); 
        int[] dp = new int[n + 1];
        dp[n] = 0; 
        dp[n-1] = 1;
        for(int i = n - 2; i >= 0; i--){
            if(s.charAt(i) == '0')
                continue; 

            int num = Integer.parseInt(s.substring( i , i + 2)); 
            System.out.println(num); 
            dp[i] = dp[i + 1]; 
            if(num > 10 && num <= 26){
                dp[i]++; 
            }
        } 
        return dp[0]; 
    }
}

/* Notes: 
    226 
    6 1 
    26 -> BF || Z 2 
    2 (26) ->  


    12 
    2 -> 1 B
    1 (2) -> 2

    226 

    6 1 
    26 1 + 1 =2 
    2 (26)

    10
*/ 
