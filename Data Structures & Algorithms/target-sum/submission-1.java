class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<String, Integer> memo = new HashMap<>(); 
        return backtrack(nums, target, 0,memo);
    }

    public int backtrack(int[] nums, int target, int index ,HashMap<String, Integer> memo){
        if(index == nums.length - 1){
            if(target + nums[index] == 0)
                return 1; 
            if(target - nums[index] == 0) 
                return 1;  
            return 0; 
        }

        if(index >= nums.length)
            return 0; 

        String key = index + "-" + target; 
        if(memo.containsKey(key ))
            return memo.get(key); 
        
        int pos = backtrack(nums, target - nums[index], index + 1, memo);
        int neg = backtrack(nums, target + nums[index], index + 1, memo);

        memo.put(key, pos + neg); 
        return pos + neg; 
    }
}


/* Notes: This is a backtracking algo and we stop when reaching th
index and target sum 

these are the states and the repetative workm in my code: 


[1 1 1 1 1 1 1 1 1 1] 6




(0, 6)


(1 7)  (1 5)

(2 8) (2 6) (2 6) (2 4)

(3 9) (3 7) (3 7) (3 5) (3 7) repeating work

however the upper bound is not target and we need to have an upperbound: 
*/