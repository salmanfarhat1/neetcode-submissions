class Solution {
    int xorSum = 0; 
    public int subsetXORSum(int[] nums) {
        backtrack(nums, 0, 0);
        return xorSum;  
    }
    public void backtrack(int[] nums, int index, int xor){
        xorSum += xor; 
        for(int i = index; i < nums.length; i++){
            backtrack(nums, i + 1, xor ^ nums[i]); 
        }
    } 
}