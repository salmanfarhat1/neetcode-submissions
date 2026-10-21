class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < intervals.length; j++) {
                if (intervals[j][0] <= queries[i] && queries[i] <= intervals[j][1]) {
                    min = Math.min(min, intervals[j][1] - intervals[j][0] + 1);
                }
            }

            result[i] = min == Integer.MAX_VALUE ? -1 : min;
        }

        return result;
    }
}