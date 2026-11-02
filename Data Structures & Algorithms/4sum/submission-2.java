class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>(); 

        for(int i = 0; i < nums.length - 3; i++){
            if(i > 0 && nums[i] == nums[i - 1])
                continue; 

            List<List<Integer>> res = threeSum(nums, (long) target - nums[i], nums[i], i + 1); 
            result.addAll(res); 
        }

        return result;
    }

    public List<List<Integer>> threeSum(int[] nums, long target, int quad, int left) {
        List<List<Integer>> result = new ArrayList<>(); 

        for(int i = left; i < nums.length - 2; i++){
            if(i > left && nums[i] == nums[i - 1])
                continue; 

            List<List<Integer>> res = twoSum(nums, target - nums[i], nums[i], quad, i + 1); 
            result.addAll(res); 
        }

        return result;
    }

    public List<List<Integer>> twoSum(int[] numbers, long target, int triplet, int quad, int left) {
        int right = numbers.length - 1; 
        List<List<Integer>> result = new ArrayList<>(); 

        while(left < right){
            long sum = (long) numbers[left] + numbers[right];

            if(sum < target)
                left++; 
            else if(sum > target){
                right--; 
            }
            else{
                result.add(Arrays.asList(quad, triplet, numbers[left], numbers[right]));
                left++; 
                right--; 

                while(left < right && numbers[left] == numbers[left - 1])
                    left++; 

                while(right > left && numbers[right] == numbers[right + 1])
                    right--; 
            }
        }

        return result;
    }
}