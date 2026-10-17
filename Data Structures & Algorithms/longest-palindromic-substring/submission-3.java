class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][i] = true;
        }

        String max = "";

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;

                        if (j - i + 1 > max.length()) {
                            max = s.substring(i, j + 1);
                        }
                    }
                }
            }
        }

        return max;
    }
}