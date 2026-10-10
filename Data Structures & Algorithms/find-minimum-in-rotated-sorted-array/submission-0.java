class Solution {
    public int findMin(int[] nums) {
        int left = 0; 
        int right = nums.length - 1;
        int min = nums[0];
        while(left <= right){
            int mid = left + (right - left) /2; 
            if(nums[mid]  < nums[right]){
                right  = mid -1; 
            }
            else{
                left = mid+1; 
            }
            min = Math.min(nums[mid], min);
        }        
        return min; 
    }
}