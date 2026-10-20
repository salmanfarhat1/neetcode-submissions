
class Solution {
    public int maxCoins(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        for (int num : nums)
            list.add(num);
        list.add(1);

        return backtrack(list, nums.length);
    }

    public int backtrack(ArrayList<Integer> nums, int size) {
        if (size == 0)
            return 0;

        int maxCoins = 0;

        for (int i = 1; i <= size; i++) {
            int coins = nums.get(i - 1) * nums.get(i) * nums.get(i + 1);

            int balloon = nums.remove(i);

            coins += backtrack(nums, size - 1);

            maxCoins = Math.max(maxCoins, coins);

            nums.add(i, balloon);
        }

        return maxCoins;
    }
}
