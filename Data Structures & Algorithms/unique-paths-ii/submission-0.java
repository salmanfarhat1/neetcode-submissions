class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length; 
        int n = obstacleGrid[0].length;

        if(obstacleGrid[m - 1][n -1] == 1)
            return 0; 

        return dfs(obstacleGrid, 0 , 0); 
    }
    public int dfs(int[][] obstacleGrid, int row, int col){
        if(row >= obstacleGrid.length || col >= obstacleGrid[0].length)
            return 0; 

        if(row == obstacleGrid.length -1  && col == obstacleGrid[0].length - 1)
            return 1; 

        if(obstacleGrid[row][col] == 1)
            return 0;
        return dfs(obstacleGrid, row + 1, col) + dfs(obstacleGrid, row, col + 1); 
    }
}


/* Notes: 
top left 


m, n >= 1 && <= 100

right + down recursive if i j == n m return 1 



*/