class Solution {
    public boolean canPartition(int[] nums) {
        if(nums.length  == 1 )
            return false; 
        
        int target = 0; 

        for(int num: nums)
            target += num;

        if(target % 2 != 0)
            return false; 

        target = target /2; 
        HashMap<String, Boolean> memo = new HashMap<>(); 
        return backtrack(nums, target, 0, memo); 
    }
    public boolean backtrack(int[] nums, int target, int index,HashMap<String, Boolean> memo ){
        if(target == 0)
            return true; 
        if(target < 0)
            return false; 
        String key = index +"-"+ target; 
        if(memo.containsKey(key))
            return memo.get(key); 
        memo.put(key, false); 
        
        for(int i =index; i < nums.length; i++){
            if(backtrack(nums, target - nums[i] , i + 1, memo)){
                memo.put(key, true); 
                return true;  
            }
        }
        return false;
    }
}


/* Notes: 
I have it exponential time complexity here 2 power n
mid value is: we need to find subset array that have value of sum(nums)/2 if that is found this will return true / false otherwise


how can we solve it is 

1, 4 = 5 


*/ 
