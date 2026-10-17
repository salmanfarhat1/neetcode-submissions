class Solution {
    int max = Integer.MIN_VALUE; 
    public int rob(int[] nums) {
        int n = nums.length; 
        return pickOrSkip(nums, 0, 0);
        
    }
    public int pickOrSkip(int[] nums, int index, int robbed){
        if(index >= nums.length){
            return robbed; 
        } 
        return Math.max(pickOrSkip(nums, index + 2, robbed + nums[index ]) ,pickOrSkip(nums, index + 1, robbed) );
    }
}
