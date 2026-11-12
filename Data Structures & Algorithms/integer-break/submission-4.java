class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        return backtrack(n, dp);
    }

    public int backtrack(int n, int[] dp) {
        if (n < 2) {
            return 1;
        }

        if (dp[n] != 0)
            return dp[n];

        int max = 0;

        for (int i = 1; i < n; i++) {
            max = Math.max(max,
                  i * Math.max(n - i,  backtrack(n - i, dp)));
        }

        dp[n] = max;
        return max;
    }
}