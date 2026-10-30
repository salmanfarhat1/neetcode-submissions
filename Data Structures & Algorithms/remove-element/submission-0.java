class Solution {
    
    public int removeElement(int[] nums, int val) {
        int left = 0; 
        int right = nums.length -1;

        while(left < right){
            if(nums[left] == val){
                while(left < right && nums[right] == val)
                    right--; 
                nums[left] = nums[right]; 
                nums[right] = val; 
            }
            left++; 
        }     
        int k = 0; 
        for(int i = nums.length -1; i >= 0; i-- ){
            if(nums[i] == val)
                k++; 
        }
        return nums.length - k;
    }
}