class Solution {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4) return false;

        int sum = 0;
        for (int stick : matchsticks) sum += stick;
        if (sum % 4 != 0) return false;

        int side = sum / 4;
        Arrays.sort(matchsticks);
        if (matchsticks[matchsticks.length - 1] > side) return false;

        return backtrack(matchsticks, side, 0, 0, 0, new boolean[matchsticks.length]);
    }

    private boolean backtrack(int[] nums, int side, int current, int sidesDone, int start, boolean[] visited) {
        if (sidesDone == 3) return true;   // 3 sides done, the leftover sticks must form the 4th

        if (current == side)               // finished a side: start the next one
            return backtrack(nums, side, 0, sidesDone + 1, 0, visited);

        for (int i = start; i < nums.length; i++) {
            if (visited[i]) continue;
            if (current + nums[i] > side) break;   // sorted ascending, so the rest are too big too

            visited[i] = true;
            if (backtrack(nums, side, current + nums[i], sidesDone, i + 1, visited))
                return true;
            visited[i] = false;

        }
        return false;
    }
}