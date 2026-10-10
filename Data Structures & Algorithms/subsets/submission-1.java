class Solution {
    ArrayList<List<Integer>> res = new ArrayList<>(); 
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<>()); 
        return res; 
    }
    public void backtrack(int[] nums, int index, List<Integer> path){
        if(index > nums.length)
            return; 

        res.add(new ArrayList<>(path));

        for(int i = index; i < nums.length; i++){
            path.add(nums[i]);
            backtrack(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    } 
}
