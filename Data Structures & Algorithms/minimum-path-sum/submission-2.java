class Solution {
    public int minPathSum(int[][] grid) {

        int m = grid.length; 
        int n = grid[0].length; 
        int[][] memo = new int[m][n];  
        for(int i =0;  i < m;i++)
            Arrays.fill(memo[i], -1);
        return dfs(grid, 0,0, new boolean[m][n] , memo); 
    }
    public int dfs(int[][] grid, int row, int col, boolean[][] visited, int[][] memo){
        if(row >= grid.length || row < 0 || col >= grid[0].length || col < 0 )
            return Integer.MAX_VALUE; 

        if(row == grid.length - 1 && col == grid[0].length -1)
            return grid[row][col]; 

        if(memo[row][col] != -1 )
            return memo[row][col]; 

        if(visited[row][col]){
            return Integer.MAX_VALUE;
        }
        visited[row][col] = true;  

        int[] xs = {1, 0}; 
        int[] ys = {0, 1}; 

        int result = Integer.MAX_VALUE; 
        for(int i =0 ; i < 2; i++){
            int newX = xs[i] + row; 
            int newY = ys[i] + col; 
            int next = dfs(grid, newX, newY, visited, memo); 
            if(next == Integer.MAX_VALUE)
                continue; 
            result = Math.min(result , grid[row][col] + next); 
        }
        memo[row][col] = result; 
        visited[row][col] = false; 
        return result; 
    }
}