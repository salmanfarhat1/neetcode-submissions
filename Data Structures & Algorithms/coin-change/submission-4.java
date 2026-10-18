class Solution {
    public int coinChange(int[] coins, int amount) {
        HashMap<Integer, Integer> memo = new HashMap<>();

        int result = backtrack(coins, amount, memo);

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int backtrack(int[] coins, int amount,
                         HashMap<Integer, Integer> memo) {

        if (amount == 0)
            return 0;

        if (amount < 0)
            return Integer.MAX_VALUE;

        if (memo.containsKey(amount))
            return memo.get(amount);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            int current = backtrack(coins, amount - coins[i], memo);

            if (current != Integer.MAX_VALUE)
                min = Math.min(min, current + 1);
        }

        memo.put(amount, min);
        return min;
    }
}