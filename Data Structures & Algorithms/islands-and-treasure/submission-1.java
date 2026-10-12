class Solution {
    //BFS
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length; 
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>(); 
        for(int i =0 ; i < m; i++){
            for(int j =  0; j < n; j++){
                if(grid[i][j] == 0)
                    q.add(new int[]{i, j});
            }
        }
        
        int[] xs = new int[]{0,0,1,-1};
        int[] ys = new int[]{1, -1, 0, 0 }; 

        boolean[][] visited = new boolean[m][n]; 
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i =  0; i < 4; i++){
                int newX = cur[0] + xs[i]; 
                int newY = cur[1] + ys[i]; 
                if(newX < 0 || newY < 0 || newX >= m || newY >= n)
                    continue; 
                if(grid[newX][newY] == 2147483647)
                {
                    grid[newX][newY] = grid[cur[0]][cur[1]] + 1; 
                    q.add(new int[]{newX, newY}); 
                }
                
            }
        } 
    }
}


/* Notes:

*/ 