class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE; 
        int curProduct = 1; 
        for(int i =0; i < nums.length; i++ ){
            if(curProduct * nums[i] > max  ){
                max =  curProduct * nums[i]; 
                curProduct = max;
            }
            else{
                curProduct = 1; 
            }
        }
        return max; 
    }
}
