class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0]; 
        int min = nums[0]; 
        int global = nums[0]; 


        for(int i = 1; i < nums.length; i++){
            int prevMax = max; 
            int prevMin = min; 
             max = Math.max(nums[i],  Math.max(nums[i] * prevMin , nums[i] * prevMax));
             min = Math.min(nums[i],  Math.min(nums[i] * prevMin , nums[i] * prevMax));
            global = Math.max(global, max ); 
        }  
        return global; 
    }
}


/*
// brute force is of time complexity of 2 power n 
// each one we decide if we take the num[i] or not and we repeat that n times so o(2 power n) 
// can we do better. ?

I can hae. n power 2 loop and check each 

2 max = 2 ,min = 2 max =2 
4 max = 8 min = 2 max = 8
-3 max = -3 min = -18 max = 8 
5 max = 5 min = 


2 min = 2 max = 2 G = 2 
4 min = 8 max = 8 G = 8
-3 min = -24 max = -3 G = 8
5 min = -120 max = 5 G = 8 
-2 min = 240 max = -2 G 

2 
how many negative numbers 

*/
