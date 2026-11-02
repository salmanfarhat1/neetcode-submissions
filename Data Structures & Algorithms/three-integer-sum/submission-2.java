class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>(); 
        for(int i = 0; i < nums.length; i++){
            List<List<Integer>> res = twoSum(nums,  - nums[i], nums[i], i + 1); 
            for(int j = 0; j < res.size(); j++){
                result.add(res.get(j)); 
            }
        }
        return new ArrayList<>(result);

    }

    public List<List<Integer>> twoSum(int[] numbers, int target, int triplet, int left) {
        int right = numbers.length -1; 
        Set<List<Integer>> result = new HashSet<>(); 

        while(left < right){
            int sum = numbers[left] + numbers[right];
            if( sum < target)
                left++; 
            else if(sum > target){
                right--; 
            }
            else{
                List<Integer> list = new ArrayList<>(); 
                list.add(numbers[left]); 
                list.add(numbers[right]); 
                list.add(triplet); 
                Collections.sort(list);
                result.add(list);
                left++; 
                right--; 
            }
        }
        return new ArrayList<>(result);
    }
}
