class Solution {
    List<List<Integer>> res = new ArrayList<>(); 
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates );
        backtrack(candidates, target, 0, new ArrayList<>(), 0); 
        return res;
    }
    public void backtrack(int[] nums, int target, int index, List<Integer> path, int curSum ){
        if(curSum > target)
            return; 
        if(curSum == target)
        {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i  = index; i < nums.length ; i++){
            if(curSum + nums[i] > target)
                return;  
            if(i > index && nums[i] == nums[i - 1])
                continue; 
            curSum += nums[i];
            path.add(nums[i]); 
            backtrack(nums, target , i + 1, path, curSum);
            curSum -= nums[i];
            path.remove(path.size() - 1);
        } 
    }
}
