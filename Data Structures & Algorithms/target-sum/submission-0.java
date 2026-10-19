class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return backtrack(nums, target, 0);
    }

    public int backtrack(int[] nums, int target, int index){
        if(index == nums.length - 1){
            if(target + nums[index] == 0)
                return 1; 
            if(target - nums[index] == 0) 
                return 1;  
            return 0; 
        }

        if(index >= nums.length)
            return 0; 
        
        int pos = backtrack(nums, target - nums[index], index + 1);
        int neg = backtrack(nums, target + nums[index], index + 1);
        return pos + neg; 
    }
}


/* Notes: This is a backtracking algo and we stop when reaching th
2   -> -2 -> -2
          -> 2 
    -> 2 


*/