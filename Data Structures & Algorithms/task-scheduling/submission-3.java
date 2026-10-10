class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char task : tasks) {
            counts.merge(task, 1, Integer::sum);
        }

        // Keep the task with the most remaining occurrences at the top.
        PriorityQueue<Integer> available =
                new PriorityQueue<>(Comparator.reverseOrder());
        available.addAll(counts.values());

        // Tasks waiting for their cooldown: [remainingCount, readyTime].
        Queue<int[]> cooling = new ArrayDeque<>();

        int time = 0;

        while (!available.isEmpty() || !cooling.isEmpty()) {
            time++;

            if (!cooling.isEmpty() && cooling.peek()[1] == time) {
                available.offer(cooling.poll()[0]);
            }

            if (!available.isEmpty()) {
                int remaining = available.poll() - 1;
                if (remaining > 0) {
                    cooling.offer(new int[] {remaining, time + n + 1});
                }
            }
        }

        return time;
    }
}