
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0);
            dfs(heights, atlantic, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j);
            dfs(heights, atlantic, m - 1, j);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited, int i, int j) {
        int m = heights.length;
        int n = heights[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n)
            return;

        if (visited[i][j])
            return;

        visited[i][j] = true;

        if (i > 0 && heights[i - 1][j] >= heights[i][j])
            dfs(heights, visited, i - 1, j);

        if (i + 1 < m && heights[i + 1][j] >= heights[i][j])
            dfs(heights, visited, i + 1, j);

        if (j > 0 && heights[i][j - 1] >= heights[i][j])
            dfs(heights, visited, i, j - 1);

        if (j + 1 < n && heights[i][j + 1] >= heights[i][j])
            dfs(heights, visited, i, j + 1);
    }
}
