
class Solution {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0], a[0])
        );

        for (int i = intervals.length - 1; i >= 0; i--) {
            int[] newInterval = intervals[i];

            PriorityQueue<int[]> temp = new PriorityQueue<>(
                pq.comparator()
            );

            while (!pq.isEmpty()) {
                int[] top = pq.poll();

                int[] merged = overlap(top, newInterval);

                if (merged != null) {
                    newInterval = merged;
                } else {
                    temp.offer(top);
                }
            }

            pq = temp;
            pq.offer(newInterval);
        }

        int[][] result = new int[pq.size()][2];

        for (int i = pq.size() - 1; i >= 0; i--) {
            result[i] = pq.poll();
        }

        return result;
    }

    public int[] overlap(int[] interval1, int[] interval2) {
        if (interval1[1] < interval2[0] ||
            interval2[1] < interval1[0]) {
            return null;
        }

        return new int[] {
            Math.min(interval1[0], interval2[0]),
            Math.max(interval1[1], interval2[1])
        };
    }
}