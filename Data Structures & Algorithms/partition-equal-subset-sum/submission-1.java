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
        
        return backtrack(nums, target, 0); 
    }
    public boolean backtrack(int[] nums, int target, int index){
        if(target == 0)
            return true; 
        if(target < 0)
            return false; 
        
        for(int i =0; i < nums.length; i++){
            if(backtrack(nums, target - nums[i] , i + 1))
                return true;  
        }
        return false;
    }
}


/* Notes: 

mid value is: we need to find subset array that have value of sum(nums)/2 if that is found this will return true / false otherwise


how can we solve it is 

1, 4 = 5 


*/ 
