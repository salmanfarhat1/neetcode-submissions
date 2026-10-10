class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length < k)
            return new int[]{getMax(nums)};

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> b - a
        );

        int left = 0;
        int right = left + k;

        for (int i = left; i < right; i++)
            pq.add(nums[i]);

        int[] result = new int[nums.length - k + 1];
        int i = 0;

        while (right <= nums.length) {
            result[i] = pq.peek();
            i++;
            pq.remove(nums[left]);
            left++;
            if (right < nums.length)
                pq.add(nums[right]);

            right++;
        }

        return result;
    }

    private int getMax(int[] nums) {
        int max = nums[0];

        for (int num : nums) {
            max = Math.max(max, num);
        }

        return max;
    }
}