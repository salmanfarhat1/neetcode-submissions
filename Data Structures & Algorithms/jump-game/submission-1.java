class Solution {
    public boolean canJump(int[] nums) {
        return backtrack(nums, 0); 
    }
    public boolean backtrack(int[] nums, int index){
        if(index == nums.length -1)
            return true; 
        boolean result = false; 
        for(int i = index +1; i <= Math.min(nums.length -1, index + nums[index] ); i++ ){
            result |= backtrack(nums, i  ); 
        }
        return result; 
    }
}
