
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2)
                    q.add(new int[] {i, j});
                else if (grid[i][j] == 1)
                    fresh++;
            }
        }

        int[] xs = {1, -1, 0, 0};
        int[] ys = {0, 0, -1, 1};
        int minutes = 0;

        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();

            for (int j = 0; j < size; j++) {
                int[] cur = q.poll();

                for (int i = 0; i < 4; i++) {
                    int newX = cur[0] + xs[i];
                    int newY = cur[1] + ys[i];

                    if (newX < 0 || newY < 0 || newX >= m || newY >= n)
                        continue;

                    if (grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        fresh--;
                        q.add(new int[] {newX, newY});
                    }
                }
            }

            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}
