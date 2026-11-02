class Solution {
    public int removeDuplicates(int[] nums) {
        int index1 = 0; 
        
        for(int i = 1; i < nums.length; i++){
            while(i < nums.length && nums[index1] == nums[i])
                i++; 
            if(i >= nums.length)
                break; 
            index1++; 
            nums[index1] = nums[i]; 
        } 
        return index1 + 1; 
    }
}