class Solution {
    Set<List<Integer>> set = new HashSet<>();  
    public List<List<Integer>> threeSum(int[] nums) {
        backtrack(nums, 0, new ArrayList<>()); 

        return new ArrayList<>(set); 
    }

    public void backtrack(int[] nums, int index, List<Integer> path){
        if(path.size() == 3){
            if(path.get(0) + path.get(1) + path.get(2) == 0){
                List<Integer> res = new ArrayList<>(path);
                Collections.sort(res); 
                set.add(res);
            }
            return; 
        } 
        if(path.size() > 3)
            return;

        for(int i = index; i < nums.length; i++){
            path.add(nums[i]); 
            backtrack(nums, i+1 , path);
            path.remove(path.size() -1);
        }
    }
}