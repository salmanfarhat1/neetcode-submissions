class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>(); 

        for(int i =0; i < nums.length ;i++){
            set.add(nums[i]); 
        }  
        int max = 0; 
        for(int num: set){
            int n = num; 
            if(set.contains(num - 1))
                continue; 
            
            int length =0; 
            while(set.contains(n)){
                length++; 
                n++; 
            }
            max = Math.max(length, max);

        }
        return max; 
    }
}
