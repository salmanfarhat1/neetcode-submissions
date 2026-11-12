class Solution {
    // int max = Integer.MIN_VALUE;
    public int integerBreak(int n) {
        if(n == 2)
            return 2; 
        return backtrack(n); 
     
    }

    public int backtrack(int n){
        if(n < 2){
            return 1;
        }
        
        int max = -10;
        for(int i = 2; i <= n ; i++){
            max = Math.max(max, i * backtrack(n - i));
        }
        return max; 
    }
}