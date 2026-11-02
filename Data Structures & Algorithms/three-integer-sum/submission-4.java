class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>(); 
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i -1])
                continue; 
            List<List<Integer>> res = twoSum(nums,  - nums[i], nums[i], i + 1); 
            result.addAll(res); 
        }
        return result;

    }

    public List<List<Integer>> twoSum(int[] numbers, int target, int triplet, int left) {
        int right = numbers.length -1; 
        List<List<Integer>> result = new ArrayList<>(); 

        while(left < right){
            int sum = numbers[left] + numbers[right];
            if( sum < target)
                left++; 
            else if(sum > target){
                right--; 
            }
            else{
                result.add(Arrays.asList(triplet, numbers[left],numbers[right]));
                left++; 
                right--; 
            }
        }
        return result;
    }
}
