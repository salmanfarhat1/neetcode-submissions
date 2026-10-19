class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length; 
        int n = matrix[0].length; 

        boolean[][] path = new boolean[m][n]; 
        int max = Integer.MIN_VALUE;
        for(int i =0; i < m;i++)
            for(int j = 0; j < n; j++)
                max = Math.max(max, dfs(matrix, i,j));  
        return max; 
    }   

    public int dfs(int[][] matrix, int row, int col){ 
        int maxPath = 1;

        int[] xs = new int[]{1, -1, 0, 0};
        int[] ys = new int[]{0, 0, -1, 1}; 


        for(int i = 0; i < 4; i++){
            int newX = xs[i] + row; 
            int newY = ys[i] + col;
            if(newX < 0 || newY < 0 || newX >= matrix.length || newY >= matrix[0].length)
                continue; 
            if(matrix[newX][newY] <= matrix[row][col ])
                continue; 
            maxPath = Math.max(maxPath, 1 + dfs(matrix, newX, newY)); 
        }

        return maxPath; 

    }
}
