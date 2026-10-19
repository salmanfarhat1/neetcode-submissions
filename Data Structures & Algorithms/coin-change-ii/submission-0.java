class Solution {
    public int change(int amount, int[] coins) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return backtrack(coins, amount, 0 ,  memo);
    }

    public int backtrack(int[] coins, int amount, int index,
                         HashMap<Integer, Integer> memo) {

        if (amount == 0)
            return 1;

        if (amount < 0)
            return 0;

        int cur = 0; 
        for (int i = index; i < coins.length; i++) {
             cur +=  backtrack(coins, amount - coins[i], i ,  memo);

        }

        return cur;
    }
}