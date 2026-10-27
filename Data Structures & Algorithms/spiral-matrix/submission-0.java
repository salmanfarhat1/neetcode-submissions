class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int m = matrix.length; // Rows
        int n = matrix[0].length; // Columns 
        int levels = Math.min(m, n) / 2; 
        List<Integer> arr = new ArrayList<>();
        System.out.println("Number of levels: " + levels);
        
        // Spiral traversal
        for (int level = 0; level < levels; level++) {
            // Traverse from left to right on the top row
            for (int i = level; i < n - level; i++) {
                arr.add(matrix[level][i]);
            }
            // Traverse from top to bottom on the right column
            for (int j = level + 1; j < m - level; j++) {
                arr.add(matrix[j][n - 1 - level]);
            }
            // Traverse from right to left on the bottom row
            for (int i = n - 1 - level - 1; i >= level; i--) {
                arr.add(matrix[m - 1 - level][i]);
            }
            // Traverse from bottom to top on the left column
            for (int j = m - 1 - level - 1; j > level; j--) {
                arr.add(matrix[j][level]);
            }
        }

        // Handle the remaining row or column if m or n is odd
        if (m > n && n % 2 != 0) { // Remaining column
            int col = n / 2;
            for (int i = levels; i < m - levels; i++) {
                arr.add(matrix[i][col]);
            }
        } else if (n > m && m % 2 != 0) { // Remaining row
            int row = m / 2;
            for (int i = levels; i < n - levels; i++) {
                arr.add(matrix[row][i]);
            }
        } else if (m == n && m % 2 != 0) { // Remaining center element in a square matrix
            arr.add(matrix[m / 2][n / 2]);
        }

        return arr; 
    }
}