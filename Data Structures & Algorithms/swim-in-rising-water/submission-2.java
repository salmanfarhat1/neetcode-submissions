class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length; 
        
         
        // for(int t = 0; t < n * n ; t++)
        // {
        //     boolean[][] visited = new boolean[n][n];
        //     if(dfs(grid, visited, t, 0,0))
        //         return t; 
        // }

        int left = 0; 
        int right = n * n;
        int t = 0;
        while(left <= right ){
            int mid = left + (right - left) / 2;
            boolean[][] visited = new boolean[n][n];
            if(dfs(grid, visited, mid, 0, 0)){
                t = mid; 
                right =mid -1; 
            }
            else{
                left = mid +1; 
            } 
        }
        return left; 
    }
    public boolean dfs(int[][] grid, boolean[][] visited, int t, int x, int y){
        if(x >= grid.length || x < 0 ||  y >= grid.length || y < 0)
            return false;

        if(grid[x][y] > t || visited[x][y])
            return false; 

        if(x == grid.length -1 && y == grid.length - 1)
            return true;

        visited[x][y] = true; 

        boolean down = false;
        boolean right = false; 
        boolean left = false; 
        boolean up = false; 

        down = dfs(grid, visited, t, x , y + 1); 
        right = dfs(grid, visited, t, x + 1, y ); 
        left = dfs(grid, visited, t, x - 1, y ); 
        up = dfs(grid, visited, t, x , y - 1 ); 

        return down || right || left || up; 
    }
}
