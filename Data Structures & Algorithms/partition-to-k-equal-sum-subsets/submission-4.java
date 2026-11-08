class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        if(n < k)
            return false;

        int sum = 0;
        for(int num : nums)
            sum += num;

        if(sum % k != 0)
            return false;

        int target = sum / k;

        if(nums[n - 1] > target)
            return false;

        boolean[] visited = new boolean[n];

        return backtrack(nums, k, target, target, visited);
    }

    public boolean backtrack(int[] nums, int k, int sum,
                             int target, boolean[] visited) {

        if(k == 0)
            return true;

        if(sum == 0)
            return backtrack(nums, k - 1, target, target, visited);

        for(int i = nums.length - 1; i >= 0; i--) {

            if(visited[i])
                continue;

            if(i < nums.length - 1 &&
               nums[i] == nums[i + 1] && !visited[i + 1])
                continue;

            if(nums[i] > sum)
                continue;

            visited[i] = true;

            if(backtrack(nums, k, sum - nums[i], target, visited))
                return true;

            visited[i] = false;

        }

        return false;
    }
}