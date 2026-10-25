class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        boolean[] visited = new boolean[n];
        int[] minDist = new int[n];

        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;                       // start from point 0

        int totalCost = 0;

        for (int i = 0; i < n; i++) {
            int next = findClosestUnvisited(visited, minDist);

            visited[next] = true;
            totalCost += minDist[next];

            updateDistances(points, next, visited, minDist);
        }

        return totalCost;
    }

    // Step 1: pick the unvisited point that is cheapest to connect
    private int findClosestUnvisited(boolean[] visited, int[] minDist) {
        int best = -1;
        int bestDist = Integer.MAX_VALUE;

        for (int j = 0; j < visited.length; j++) {
            if (!visited[j] && minDist[j] < bestDist) {
                bestDist = minDist[j];
                best = j;
            }
        }

        return best;
    }

    // Step 2: after adding a point, see if it offers a cheaper connection
    // to any point that is still unvisited
    private void updateDistances(int[][] points, int added,
                                 boolean[] visited, int[] minDist) {
        for (int j = 0; j < points.length; j++) {
            if (!visited[j]) {
                int dist = manhattanDistance(points[added], points[j]);
                minDist[j] = Math.min(minDist[j], dist);
            }
        }
    }

    // Helper: distance between two points
    private int manhattanDistance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}