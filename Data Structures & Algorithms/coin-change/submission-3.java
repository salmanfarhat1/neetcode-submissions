class Solution {
    int nbCoins = -1; 
    Integer[][] memo;
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int n = coins.length;
        memo = new Integer[n][amount + 1];
        return backtrack(coins, amount, coins.length - 1);
    }
    public int backtrack(int[] coins, int amount, int index) {
        if (amount == 0)
            return 0;

        if (index == -1)
            return -1;

        if(memo[index][amount] != null)
            return memo[index][amount];

        int pick = -1;

        if (amount >= coins[index]) {
            int res = backtrack(coins, amount - coins[index], index);
            if (res != -1)
                pick = 1 + res;
        }

        int skip = backtrack(coins, amount, index - 1);

        if (pick == -1){
            memo[index][amount] = skip; 
            return skip;
        }
        if (skip == -1){
            memo[index][amount] = pick; 
            return pick;
        }
            
        memo[index][amount] = Math.min(pick, skip); 
        return Math.min(pick, skip);
    }
}