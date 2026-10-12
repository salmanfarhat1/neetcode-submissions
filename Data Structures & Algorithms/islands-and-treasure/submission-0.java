class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == -1)
                    continue;
                if (grid[i][j] == 0)
                    continue;
                grid[i][j] = dfs(grid, i, j, visited);
            }
        }
    }

    public int dfs(int[][] grid, int row, int col,
                   boolean[][] visited) {

        if (row < 0 || col < 0 ||
            row >= grid.length || col >= grid[0].length)
            return Integer.MAX_VALUE;

        if (grid[row][col] == -1)
            return Integer.MAX_VALUE;

        if (grid[row][col] == 0)
            return 0;

        if (visited[row][col])
            return Integer.MAX_VALUE;

        visited[row][col] = true;

        int[] xs = {0, 0, 1, -1};
        int[] ys = {-1, 1, 0, 0};

        int nearest = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++) {
            int newX = row + xs[i];
            int newY = col + ys[i];

            int path = dfs(grid, newX, newY, visited);

            nearest = Math.min(nearest, path);
        }

        visited[row][col] = false;

        if (nearest == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        return nearest + 1;
    }
}