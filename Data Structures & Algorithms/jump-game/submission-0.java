class Solution {
    public boolean canJump(int[] nums) {
        return backtrack(nums, 0); 
    }
    public boolean backtrack(int[] nums, int index){
        if(index == nums.length -1)
            return true; 
        boolean result = false; 
        for(int i = index; i < Math.min(nums.length, index + nums[index]); i++ ){
            result |= backtrack(nums, i +1 ); 
        }
        return result; 
    }
}
