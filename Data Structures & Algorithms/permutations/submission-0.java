class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        List<List<Integer>> result = new ArrayList<>(); 
        backtrack(nums , new ArrayList<>(), visited, result);
        return result; 
    }
    public void backtrack(int[] nums, List<Integer> path, boolean[] visited, List<List<Integer>> result){
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return; 
        }

        for(int i = 0; i < nums.length; i++){
            if(visited[i])
                continue;
            visited[i] = true; 
            path.add(nums[i]);
            backtrack(nums, path,visited, result); 
            visited[i] = false; 
            path.remove(path.size() - 1); 
        } 
    }
}
