class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length == 1)
            return false;

        int target = 0;

        for (int num : nums)
            target += num;

        if (target % 2 != 0)
            return false;

        target = target / 2;

        boolean[] dp = new boolean[target + 1];

        dp[0] = true;

        for (int num : nums) {
            for (int i = target - num; i >= 0; i--) {
                if (dp[i] == true) {
                    dp[num + i] = true;
                }
            }
        }

        return dp[target];
    }
}