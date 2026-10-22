class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curTank = 0;

        for (int i = 0; i < gas.length; i++) {
            curTank = gas[i];
            boolean valid = true;

            for (int j = (i + 1) % gas.length; j != i;
                 j = (j + 1) % gas.length) {

                curTank -= cost[(j - 1 + gas.length) % gas.length];

                if (curTank < 0) {
                    valid = false;
                    break;
                }

                curTank += gas[j];
            }

            if (valid && curTank >= cost[(i - 1 + gas.length) % gas.length])
                return i;
        }

        return -1;
    }
}