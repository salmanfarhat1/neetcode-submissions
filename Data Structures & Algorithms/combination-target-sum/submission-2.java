class Solution {
    Set<List<Integer>> res = new HashSet<>(); 
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums); 
        backtrack(nums, target, 0, new ArrayList<>(), 0); 
        return new ArrayList<>(res); 
    }
    public void backtrack(int[] nums , int target, int index, List<Integer> path, int curSum){
        if(curSum == target)
        {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = index; i < nums.length; i++){
            if(curSum + nums[i] > target)
                return; 
            path.add(nums[i]);
            curSum += nums[i];
            backtrack(nums, target, i, path ,  curSum); 
            curSum -= nums[i]; 
            path.remove(path.size() -1); 
        }
    } 
}
