class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];  
        for(int i = 0; i <= n; i++){
            result[i] = bits(i);
        }
        return result; 
    }
    public int bits(int n){
        int ones = 0;
        while(n != 0){
            if((n & 1) == 1)
                ones++; 
            n = n /2; 
        }
        return ones; 
    }
}
