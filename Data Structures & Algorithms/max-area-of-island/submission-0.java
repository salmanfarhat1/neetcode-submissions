class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length; 
        int n = grid[0].length; 
        int maxArea = 0; 
        for(int i = 0; i < m; i++){
            for(int j =  0; j < n ; j++){
                if(grid[i][j] == 1){
                    int area = dfs(grid, i,j);
                    if(maxArea < area)
                        maxArea = area;
                }
            }
        }
        return maxArea; 
    }
    public int dfs(int[][] grid, int row, int col ){
        if(row >= grid.length || row < 0 || col >= grid[0].length || col < 0){
            return 0 ;  
        }
        if(grid[row][col] == 0)
            return 0;

        grid[row][col] = 0; 

        int[] xs = new int[]{1,-1,0, 0}; 
        int[] ys = new int[]{0, 0, 1, -1}; 
        int area = 1; 
        for(int i = 0; i < 4; i++){
            int newX = row + xs[i]; 
            int newY = col + ys[i]; 
           
            area +=  dfs(grid , newX, newY);
        }
        return area; 
    }
}

