class Solution {
    public int minPathSum(int[][] grid) {

        int m = grid.length; 
        int n = grid[0].length; 

        return dfs(grid, 0,0, new boolean[m][n]); 
    }
    public int dfs(int[][] grid, int row, int col, boolean[][] visited){
        if(row >= grid.length || row < 0 || col >= grid[0].length || col < 0 )
            return Integer.MAX_VALUE; 

        if(row == grid.length - 1 && col == grid[0].length -1)
            return grid[row][col]; 

        if(visited[row][col]){
            return Integer.MAX_VALUE;
        }
        visited[row][col] = true;  

        int[] xs = {1, -1, 0, 0}; 
        int[] ys = {0, 0, 1, -1}; 

        int result = Integer.MAX_VALUE; 
        for(int i =0 ; i < 4; i++){
            int newX = xs[i] + row; 
            int newY = ys[i] + col; 
            int next = dfs(grid, newX, newY, visited); 
            if(next == Integer.MAX_VALUE)
                continue; 
            result = Math.min(result , grid[row][col] + next ); 
        }
        visited[row][col] = false; 
        return result; 
    }
}