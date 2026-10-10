class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // skip duplicate anchors
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            List<List<Integer>> res = twoSum(nums, -nums[i], i);
            if (res == null || res.isEmpty())
                continue;
            for (List<Integer> pair : res) {
                List<Integer> triplet = new ArrayList<>(pair);
                triplet.add(nums[i]);
                Collections.sort(triplet);
                result.add(triplet);
            }
        }
        return result;
    }

    public List<List<Integer>> twoSum(int[] numbers, int target, int index) {
        List<List<Integer>> results = new ArrayList<>();
        int left = index + 1;
        int right = numbers.length - 1;

        while (left < right) {
            int curSum = numbers[left] + numbers[right];
            if (curSum == target) {
                results.add(new ArrayList<>(
                    Arrays.asList(numbers[left], numbers[right])
                ));
                left++;
                right--;
                // skip duplicates on both sides
                while (left < right && numbers[left] == numbers[left - 1])
                    left++;
                while (left < right && numbers[right] == numbers[right + 1])
                    right--;
            } else if (curSum < target) {
                left++;
            } else {
                right--;
            }
        }

        return results;
    }
}