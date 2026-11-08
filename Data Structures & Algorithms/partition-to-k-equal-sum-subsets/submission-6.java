class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums); 
        int n = nums.length;

        if(n < k)
            return false; 

        int sum = 0; 
        for(int num : nums)
            sum +=num; 
        
        if(sum % k != 0) 
            return false; 
        
        boolean[] visited = new boolean[n]; 
        return backtrack(nums, k, sum/k, sum/k, visited); 
    }


    //[1,2,3,4,5]
    public boolean backtrack(int[] nums, int k, int sum, int nOverK,  boolean[] visited){
        if(k == 0)
            return true; 

        if(sum == 0){
            return backtrack(nums, k - 1, nOverK, nOverK, visited);
        }

        if(sum < 0)
            return false;
        
        for(int i = 0; i< nums.length;i++){
            if(i > 0 && nums[i] == nums[i -1] && !visited[i - 1])
                continue; 
            if(visited[i])
                continue; 
            if(sum < nums[i])
                continue; 

            visited[i] = true; 

            if(backtrack(nums, k, sum - nums[i], nOverK, visited))
                return true;
            visited[i] = false;  
            
        }
        return false; 
        
    }
}