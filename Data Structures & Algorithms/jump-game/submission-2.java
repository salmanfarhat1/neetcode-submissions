class Solution {
    public boolean canJump(int[] nums) {
        Boolean[] memo = new Boolean[nums.length]; 
        return backtrack(nums, 0, memo); 
    }
    public boolean backtrack(int[] nums, int index,  Boolean[] memo){
        if(index == nums.length -1)
            return true; 
        if(memo[index] != null)
            return memo[index];
        boolean result = false; 
        for(int i = index +1; i <= Math.min(nums.length -1, index + nums[index] ); i++ ){
            result |= backtrack(nums, i, memo  ); 
        }
        memo[index] = result; 
        return result; 
    }
}
