class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length; 
        int[] conc = new int[2*n];

        for(int i =0; i < n; i++){
            conc[i] = nums[i]; 
            conc[n + i] = nums[i];
        } 
        return conc;
    }
}