class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums); 
        boolean[] visited = new boolean[nums.length]; 
        List<List<Integer>> result = new ArrayList<>(); 
        backtrack(nums, 0, visited,   new ArrayList<>(), result);
        return result;  
    }
    public void backtrack(int[] nums, int index, boolean[] visited, List<Integer> path, List<List<Integer>> result){


        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return; 
        }

        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i -1] && !visited[i -1])
                continue; 
            if(visited[i] == true)
                continue; 

            visited[i] = true;
            path.add(nums[i]); 
            backtrack(nums, i+1, visited, path, result);
            path.remove(path.size() - 1);
            visited[i] = false; 
        }

    }
}