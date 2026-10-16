class Solution {
    int ways = 0; 
    public int climbStairs(int n) {
        return takeOrSkip(n , 0); 
    }
    public int takeOrSkip(int n, int pos){
        if(pos == n){
            return 1; 
        }
        if(pos > n )
            return 0; 

        int result = 0; 
        result += takeOrSkip(n , pos + 1); 
        result += takeOrSkip(n , pos + 2); 
        return result; 
    }
}
