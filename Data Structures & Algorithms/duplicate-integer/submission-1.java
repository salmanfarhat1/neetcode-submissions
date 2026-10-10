class Solution {
    public boolean hasDuplicate(int[] nums) {
         Set<Integer> freq = new HashSet(); 

        for(int i= 0 ;i < nums.length; i++){
            if(freq.contains(nums[i]))
                return true; 
            
            freq.add(nums[i]); 
        }
        return false;
    }
}