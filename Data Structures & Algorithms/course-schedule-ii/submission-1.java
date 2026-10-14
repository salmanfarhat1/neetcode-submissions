
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        constructGraph(prerequisites, numCourses, graph);

        boolean[] visited = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        List<Integer> sequence = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, i, visited, path, sequence))
                return new int[]{};
        }

        int[] result = new int[sequence.size()];
        for (int i = 0; i < sequence.size(); i++) {
            result[i] = sequence.get(i);
        }

        return result;
    }

    public boolean dfs(HashMap<Integer, List<Integer>> graph,
                       int course,
                       boolean[] visited,
                       boolean[] path,
                       List<Integer> sequence) {

        if (path[course])
            return false;

        if (visited[course])
            return true;

        path[course] = true;

        for (int neighbor : graph.get(course)) {
            if (!dfs(graph, neighbor, visited, path, sequence))
                return false;
        }

        path[course] = false;
        visited[course] = true;
        sequence.add(course);

        return true;
    }

    public void constructGraph(int[][] prerequisites,
                               int numCourses,
                               HashMap<Integer, List<Integer>> graph) {
        for (int i = 0; i < numCourses; i++)
            graph.put(i, new ArrayList<>());

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];

            graph.get(course).add(prerequisite);
        }
    }
}
