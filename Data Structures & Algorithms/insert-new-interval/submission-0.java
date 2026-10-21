class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;

        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval = overlap(newInterval, intervals[i]);
            i++;
        }

        result.add(newInterval);

        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    public int[] overlap(int[] interval1, int[] interval2) {
        int min = Math.min(interval1[0], interval2[0]);
        int max = Math.max(interval1[1], interval2[1]);

        return new int[]{min, max};
    }
}