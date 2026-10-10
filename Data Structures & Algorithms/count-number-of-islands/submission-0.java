class Solution {
    public int numIslands(char[][] grid) {
        //DFS solution:
        int m = grid.length; 
        int n = grid[0].length; 
        int counter = 0; 
        for(int i = 0; i < m; i++){
            for(int j =  0; j < n ; j++){
                if(grid[i][j] == '1'){
                    System.out.println( " i : " + i + " j : " + j ); 
                    dfs(grid, i,j);
                    counter++;
                }
            }
        }
        return counter; 
    }
    public void dfs(char[][] grid, int row, int col ){
        if(row >= grid.length || row < 0 || col >= grid[0].length || col < 0){
            return;  
        }
        if(grid[row][col] == '0')
            return;

        grid[row][col] = '0'; 
        int[] xs = new int[]{1,-1,0, 0}; 
        int[] ys = new int[]{0, 0, 1, -1}; 

        for(int i = 0; i < 4; i++){
            int newX = row + xs[i]; 
            int newY = col + ys[i]; 
           
            dfs(grid , newX, newY);
        }
    }
}

