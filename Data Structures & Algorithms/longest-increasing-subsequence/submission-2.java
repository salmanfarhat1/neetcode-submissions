class Solution {
    public int lengthOfLIS(int[] nums) {
        HashMap<String , Integer > memo = new HashMap<>(); 
        return backtrack(nums,  0 , Integer.MIN_VALUE, 0, memo);
    }

    public int backtrack(int[] nums, int pos, int lastInt, int lis, HashMap<String, Integer > memo){
        if(pos == nums.length)
            return lis; 
        
        String key = pos + "-" + lastInt + "-"+lis; 

        if(memo.containsKey(key))
            return memo.get(key); 
        int r1 = lis; 
        for(int i = pos; i < nums.length; i++){
            if(nums[i] <= lastInt)
                continue; 
            r1 = Math.max(r1, backtrack(nums, i + 1, nums[i], lis + 1, memo));
    } 
        memo.put(key, r1);
        return r1; 
    }
}

// then time complexity is O(n * n - 1 * n -2 .... )
// or it is 2 power n ? 