class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length; 
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n]; 
        for(int i =  0; i < m; i++)
            Arrays.fill(dp[i], -1); 

        if(obstacleGrid[m - 1][n -1] == 1)
            return 0; 

        return dfs(obstacleGrid, 0 , 0, dp); 
    }
    public int dfs(int[][] obstacleGrid, int row, int col, int[][] dp){
        if(row >= obstacleGrid.length || col >= obstacleGrid[0].length)
            return 0; 

        if(row == obstacleGrid.length -1  && col == obstacleGrid[0].length - 1)
            return 1; 

        if(obstacleGrid[row][col] == 1)
            return 0;
        if(dp[row][col] != -1)
            return dp[row][col]; 
        int result =  dfs(obstacleGrid, row + 1, col, dp) + dfs(obstacleGrid, row, col + 1, dp); 
        dp[row][col] = result; 
        return result; 
    }
}




/* Notes: 
top left 


m, n >= 1 && <= 100

right + down recursive if i j == n m return 1 

TC = o()
each call have 2 calls at most 

00  01  11
        02


    10  11  repeated work 
        20 

    I can have a memo to save it up based ob the row and col

*/