class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; 
        int n = matrix[0].length; 

        int left = 0; 
        int right = m -1 ; 
        int mid = -1; 

        while(left <= right){
            mid = left + (right - left) /2; 
            if(matrix[mid][0] == target)   return true; 
            else if(target > matrix[mid][0]) {
                if(target <= matrix[mid][0])
                    break;
                 left = mid + 1; 
            }
            else {
                right = mid - 1;
            }
        }

        if(mid == -1)
            return false;

        int row = mid;
        left = 0; 
        right = n -1; 

        while(left <= right){
            mid = left + (right - left) /2; 
            if(matrix[row][mid] == target)   return true; 
            else if(target > matrix[row][mid])  left = mid + 1; 
            else right = mid - 1;
        }
        return false; 
    }
}