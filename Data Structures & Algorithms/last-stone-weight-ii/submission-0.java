class Solution {

    public int lastStoneWeightII(int[] stones) {
        return backtrack(stones);
    }

    private int backtrack(int[] stones) {

        int remaining = 0;
        int last = 0;

        for (int stone : stones) {
            if (stone != -1) {
                remaining++;
                last = stone;
            }
        }

        if (remaining <= 1) {
            return last;
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < stones.length; i++) {
            if (stones[i] == -1) continue;

            for (int j = i + 1; j < stones.length; j++) {
                if (stones[j] == -1) continue;

                int a = stones[i];
                int b = stones[j];

                // Remove both stones
                stones[i] = -1;
                stones[j] = -1;

                // Add the resulting stone if they are different
                if (a != b) {
                    stones[i] = Math.abs(a - b);
                }

                min = Math.min(min, backtrack(stones));

                // Backtrack: restore original state
                stones[i] = a;
                stones[j] = b;
            }
        }

        return min;
    }
}