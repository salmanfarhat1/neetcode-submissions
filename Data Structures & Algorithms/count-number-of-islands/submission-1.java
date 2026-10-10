class Solution {
    public int numIslands(char[][] grid) {
        Queue<int[]> qZeros = new Queue<>();
        qZeros.add(grid[0][0]);
        grid[0][0] = 'v';
        
        while(!qZeros.isEmpty() && !qOnes.isEmpty()){
            while(!qZeros.isEmpty()){
                int[] pos = qZeros.poll(); 
                int[] xs = {0, 0 , 1, -1};
                for(int i = 0; i < 4; i++){
                    
                }
            }
        } 

    }
    public void dfs(char[][] grid, int row, int col ){
        
        
    }
}

