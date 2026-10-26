
class Solution {
    public String foreignDictionary(String[] words) {
        HashMap<Character, List<Character>> graph = new HashMap<>();

        // Include every character in the graph
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList<>());
            }
        }

        String prev = words[0];

        for (int i = 1; i < words.length; i++) {
            String cur = words[i];
            int j = 0, k = 0;

            while (j < prev.length() && k < cur.length()
                    && prev.charAt(j) == cur.charAt(k)) {
                j++;
                k++;
            }

            // Invalid ordering: "abcd" comes before "ab"
            if (k == cur.length() && j < prev.length()) {
                return "";
            }

            if (j < prev.length() && k < cur.length()) {
                List<Character> neighbors =
                    graph.get(prev.charAt(j));

                neighbors.add(cur.charAt(k));
            }

            prev = cur;
        }

        int[] state = new int[26];
        StringBuilder result = new StringBuilder();

        for (char c : graph.keySet()) {
            if (state[c - 'a'] == 0) {
                if (!dfs(graph, c, state, result)) {
                    return "";
                }
            }
        }

        return result.reverse().toString();
    }

    public boolean dfs(
            HashMap<Character, List<Character>> graph,
            char c,
            int[] state,
            StringBuilder result) {

        if (state[c - 'a'] == 1) {
            return false; // Cycle detected
        }

        if (state[c - 'a'] == 2) {
            return true; // Already processed
        }

        state[c - 'a'] = 1;

        List<Character> neighbors = graph.get(c);

        for (int i = 0; i < neighbors.size(); i++) {
            char neigh = neighbors.get(i);

            if (!dfs(graph, neigh, state, result)) {
                return false;
            }
        }

        state[c - 'a'] = 2;
        result.append(c);

        return true;
    }
}
