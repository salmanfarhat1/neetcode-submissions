class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(map.get(b), map.get(a))
        );

        pq.addAll(map.keySet());

        ArrayList<Character> list = new ArrayList<>();

        while (!pq.isEmpty()) {

            ArrayList<Character> skipped = new ArrayList<>();
            boolean found = false;

            while (!pq.isEmpty()) {
                char task = pq.poll();

                int start = Math.max(0, list.size() - n);

                // Check if task was used in the last n slots
                if (list.subList(start, list.size()).contains(task)) {
                    skipped.add(task);
                    continue;
                }

                // Task is eligible
                list.add(task);
                map.put(task, map.get(task) - 1);
                found = true;

                // Still has remaining occurrences
                if (map.get(task) > 0) {
                    skipped.add(task);
                }

                break;
            }

            // Put skipped tasks back
            for (char task : skipped) {
                if (map.get(task) > 0) {
                    pq.add(task);
                }
            }

            // Nothing was eligible -> idle
            if (!found) {
                list.add('I');
            }
        }

        return list.size();
    }
}