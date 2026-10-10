class Solution {
    public int findDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(nums[nums[i] - 1] == i + 1) continue;
            if(nums[nums[i] -1] == nums[i]) 
                return nums[i];
            nums[nums[i] -1] = nums[i];
        }
        return -1; 
    }

    
}
