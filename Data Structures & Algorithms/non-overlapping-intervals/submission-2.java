
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        HashMap<String, Integer> memo = new HashMap<>();
        return backtrack(intervals, new ArrayList<>(), 0, memo);
    }

    public void printPath(List<int[]> path) {
        for (int[] interval : path) {
        }
    }

    public int backtrack(int[][] intervals, List<int[]> path, int index,
                         HashMap<String, Integer> memo) {

        String key = index + ":";
        for (int[] interval : path) {
            key += interval[0] + "," + interval[1] + ";";
        }

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (index == intervals.length) {
            printPath(path);
            if (nonOverLap(path)) {
                return intervals.length - path.size();
            } else {
                return Integer.MAX_VALUE;
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = index; i < intervals.length; i++) {
            path.add(intervals[i]);
            min = Math.min(min, backtrack(intervals, path, i + 1, memo));
            path.remove(path.size() - 1);
        }

        memo.put(key, min);
        return min;
    }

    public boolean nonOverLap(List<int[]> intervals) {
        if (intervals.size() == 0)
            return true;

        for (int i = 1; i < intervals.size(); i++) {
            int[] prev = intervals.get(i - 1);
            int[] cur = intervals.get(i);
            if (overlap(prev, cur))
                return false;
        }
        return true;
    }

    public boolean overlap(int[] interval1, int[] interval2) {
        if (interval1[1] > interval2[0])
            return true;
        return false;
    }
}
