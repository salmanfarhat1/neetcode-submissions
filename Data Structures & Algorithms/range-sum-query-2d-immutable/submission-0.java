class NumMatrix {
    int[][] matrix; 

    public NumMatrix(int[][] matrix) {
        int m = matrix.length; 
        int n = matrix[0].length; 

        this.matrix = new int[m + 1][n + 1]; 

        for(int i = 0; i < m; i++){
            this.matrix[i][n - 1] = matrix[i][n - 1]; 
        }

        for(int i = 0; i < n; i++){
            this.matrix[m - 1][i] = matrix[m - 1][i]; 
        }

        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                this.matrix[i][j] = matrix[i][j]
                    + this.matrix[i+1][j]
                    + this.matrix[i][j+1]
                    - this.matrix[i+1][j+1]; 
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = matrix[row1][col1] - matrix[row1][col2 + 1] 
                - matrix[row2 + 1][col1] 
                + matrix[row2 + 1][col2 + 1]; 

        return sum; 
    }
}