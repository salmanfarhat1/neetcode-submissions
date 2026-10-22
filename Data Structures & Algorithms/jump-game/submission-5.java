class Solution {
    public boolean canJump(int[] nums){
        if(nums[0] == 0 && nums.length != 1)
            return false; 
        nums[nums.length -1] = 10000;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1 && nums[i +1] == 0)
                return false; 
        }
        return true; 
    }
   
}
