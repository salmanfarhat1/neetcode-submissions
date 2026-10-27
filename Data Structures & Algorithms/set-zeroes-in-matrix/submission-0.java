class Solution {
    public void setZeroes(int[][] matrix) {
        Queue<int[]> points = new LinkedList<>(); 

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0)
                    points.add(new int[]{i, j}); 
            }
        } 

        while(!points.isEmpty()){
            int[] p = points.poll(); 
            for(int i = 0; i < matrix.length; i++){
                matrix[i][p[1]] = 0;
            }
            for(int j = 0; j < matrix[0].length; j++){
                matrix[p[0]][j] = 0;
            }
        }
    
    }
}
