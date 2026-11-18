class Solution {
    public int lastStoneWeightII(int[] stones) {
        int total = 0;
        for (int s : stones) total += s;

        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int s : stones) {
            for (int j = target; j >= s; j--) {
                if (dp[j - s]) dp[j] = true;
            }
        }

        for (int j = target; j >= 0; j--) {
            if (dp[j]) return total - 2 * j;
        }
        return 0;
    }

    public boolean stoneGame(int[] piles) {
        return play(piles, 0, piles.length - 1, 0, 0, true);
    }

    private boolean play(int[] piles, int l, int r, int alice, int bob, boolean turn) {
        if (l > r) return alice > bob;

        boolean takeLeft = play(piles, l + 1, r,
                alice + (turn ? piles[l] : 0),
                bob + (turn ? 0 : piles[l]), !turn);

        boolean takeRight = play(piles, l, r - 1,
                alice + (turn ? piles[r] : 0),
                bob + (turn ? 0 : piles[r]), !turn);

        return turn ? (takeLeft || takeRight) : (takeLeft && takeRight);
    }
}