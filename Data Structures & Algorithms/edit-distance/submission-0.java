class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(); 
        int n = word2.length();

        int[][] dp = new int[m +1][n + 1]; 

        int counter = 0; 
        for(int i = m; i >=0 ; i--)
            dp[i][n] = counter++; 
        counter = 0; 
        for(int i = n; i >= 0 ; i--)
            dp[m][i] = counter++;


        for(int i = m - 1; i >= 0; i--){
            for(int j = n -1; j >= 0; j--){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = dp[i + 1 ][j +1];
                }
                else{
                    dp[i][j] = Math.min( 1 + dp[i +1][j +1] , 
                        Math.min( 1 + dp[i +1][j], 
                        1 + dp[i][j +1])); 
                }
            }
        }
        // printDP(dp);  
            
        return dp[0][0]; 
    }

    public void   printDP(int[][] dp){
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++)
                System.out.print( dp[i][j] + " "); 
            System.out.println(); 
        }
    }
}
