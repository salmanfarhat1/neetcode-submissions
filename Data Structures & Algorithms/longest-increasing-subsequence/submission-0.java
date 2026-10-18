class Solution {
    int max = Integer.MIN_VALUE;
    public int lengthOfLIS(int[] nums) {
        backtrack(nums,  0 , Integer.MIN_VALUE, 0);
        return (max == Integer.MIN_VALUE) ? 0 : max;  
    }

    public void backtrack(int[] nums, int pos, int lastInt, int lis){
        if(pos > nums.length)
            return; 
        
        max = Math.max(lis, max); 

        for(int i = pos; i < nums.length; i++){
            if(nums[i] <= lastInt)
                continue; 

            backtrack(nums, i + 1, lastInt, lis);
            backtrack(nums, i + 1, nums[i], lis + 1); 
            
        } 
    }
}




// then time complexity is O(n * n - 1 * n -2 .... )
// or it is 2 power n ? 