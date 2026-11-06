class Solution {
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks.length < 4)
            return false;

        int sum = 0;
        for(int stick : matchsticks)
            sum += stick;

        if(sum % 4 != 0)
            return false;

        Arrays.sort(matchsticks);

        int side = sum / 4;

        if(matchsticks[matchsticks.length - 1] > side)
            return false;

        boolean[] visited = new boolean[matchsticks.length];

        return backtrack(matchsticks, side, 0, 0, visited);
    }

    public boolean backtrack(int[] nums, int side, int index, int sides, boolean[] visited) {

        if(sides == 3)
            return true;

        if(index == nums.length)
            return false;

        if(side == 0)
            return backtrack(nums, side, 0, sides + 1, visited);

        for(int i = index; i < nums.length; i++) {

            if(visited[i] || side < nums[i])
                continue;

            visited[i] = true;

            if(backtrack(nums, side - nums[i], i + 1, sides, visited))
                return true;

            visited[i] = false;
        }

        return false;
    }
}