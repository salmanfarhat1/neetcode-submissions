class Solution {
    public void solve(char[][] board) {
        int m = board.length; 
        int n = board[0].length; 
        char[][] newboard = new char[m][n]; 

        for(int i = 0; i < m; i++){
            for(int j =0; j < n; j++){
                newboard[i][j] =  board[i][j]; 
                board[i][j] = 'X'; 
            }
        }

        boolean[][] visited = new boolean[m][n]; 
        for(int i = 0; i < m; i++){
            if(newboard[i][0] == 'O')
                dfs(board, newboard, visited, i, 0);
            if(newboard[i][n -1] == 'O')
                dfs(board, newboard, visited, i, n -1);
            
            
        }
        for(int i = 0; i < n; i++){
            if(newboard[0][i] == 'O')
                dfs(board, newboard, visited, 0, i);
            if(newboard[m-1][i] == 'O')
                dfs(board, newboard, visited, m - 1, i); 
            
        }


    }
    public void dfs(char[][] board, char[][] newboard, boolean[][] visited, int row, int col){

        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length)
            return; 

        if(visited[row][col]){
            return;
        }

        visited[row][col] = true; 

        if(newboard[row][col] == 'X')
            return; 


        int[] xs = {1, -1, 0, 0}; 
        int[] ys = {0 , 0, -1, 1};
        board[row][col] = 'O';
        for(int i = 0; i < 4;i++){
            int newX = xs[i] + row; 
            int newY = ys[i] + col; 
            dfs(board,newboard, visited, newX, newY); 
        }
    }
}
