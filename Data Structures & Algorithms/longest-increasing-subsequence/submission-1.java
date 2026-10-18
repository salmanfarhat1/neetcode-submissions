class Solution {
    public int lengthOfLIS(int[] nums) {
        HashMap<Integer, Integer > memo = new HashMap<>(); 
        return backtrack(nums,  0 , Integer.MIN_VALUE, 0, memo);
    }

    public int backtrack(int[] nums, int pos, int lastInt, int lis, HashMap<Integer, Integer > memo){
        if(pos == nums.length)
            return lis; 

        // if(memo.containsKey(pos))
        //     return memo.get(pos); 
        int r1 = lis; 
        for(int i = pos; i < nums.length; i++){
            if(nums[i] <= lastInt)
                continue; 
            r1 = Math.max(r1, backtrack(nums, i + 1, nums[i], lis + 1, memo));
    } 
        // memo.put(pos, Math.max(r1 , r2));
        return r1; 
    }
}

// then time complexity is O(n * n - 1 * n -2 .... )
// or it is 2 power n ? 