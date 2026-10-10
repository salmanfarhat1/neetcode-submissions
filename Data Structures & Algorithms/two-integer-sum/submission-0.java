class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); 

        for(int i =0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                if(i < map.get(target - nums[i]))
                    return new int[]{i, map.get(target - nums[i])}; 
                return new int[]{ map.get(target - nums[i]), i}; 
            }
            map.put(nums[i], i);
        }
        return null; // never here due to input assumptions;
    }
}
