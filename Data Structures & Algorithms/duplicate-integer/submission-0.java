class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap(); 

        for(int i= 0 ;i < nums.length; i++){
            int counter = freq.getOrDefault(nums[i],0);
            if(counter >= 1 )
                return true; 
            counter++; 
            freq.put(nums[i], counter); 
        }
        return false;
    }
}