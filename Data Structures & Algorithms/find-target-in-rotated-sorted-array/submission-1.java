class Solution {
    public int search(int[] nums, int target) {
        int left = 0; 
        int right = nums.length - 1; 

        while(left <= right){
            int mid = left + (right - left) /2; 
            if(nums[mid] == target)
                return mid; 
            else if(nums[mid] < nums[right] && target <  nums[mid])
                right = mid -1 ;
            else if(nums[mid] < nums[right] && target >  nums[mid])  
                left = mid + 1; 
            else if(nums[mid] >  nums[right] && target < nums[left])
                left = mid + 1; 
            else{
                right =  mid -1; 
            }
            

            System.out.println(" left : " + left  + " right : " + right + " mid: " + mid ); 
        }
        return -1;
    }
}
