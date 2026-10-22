class Solution {
    public boolean canJump(int[] nums) {
        int prev = 0; 
        for(int i = 0; i < nums.length - 1; i++){
            int jump = nums[i]; 
            if(prev == 0 && jump == 0)  
                return false; 
            else{
                if(jump >= prev){
                    prev= jump;
                }
                prev--; 
            }
        }
        return true; 
    }
}
