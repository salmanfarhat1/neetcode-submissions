class Solution {
    public List<List<String>> solveNQueens(int n) {
        //fill path with .... dots
        List<String> board = new ArrayList<>(); 
        String s = "";
        for(int i = 0; i < n; i++)
            s += "."; 
        for(int i = 0; i < n; i++)
            board.add(s); 

        List<List<String>> result = new ArrayList<>(); 
        backtrack(n, 0,  board , 0, 0, result); 
        return result; 
    }
    public void backtrack(int n, int nQueens, List<String> board,  int levelStart, int y, List<List<String>> result){
        if( nQueens == n ){
            result.add(new ArrayList<>(board)); 
            return; 
        }
        

        for(int level = levelStart; level < n; level++){
            for(int i = y; i < n; i++){
                if(noQueenHorizantallyOrVertically(board, level, i) && noQueenDiagonally(board, level, i) ){
                    char[] row = board.get(level).toCharArray();
                    row[i] = 'Q';
                    board.set(level, new String(row));

                    backtrack(n, nQueens + 1, board, level + 1, 0, result); 

                    row[i] = '.';
                    board.set(level, new String(row));
                }
            }
        } 
    } 

    public boolean noQueenHorizantallyOrVertically(List<String> board, int x, int y) {
        // Check horizontal
        for(int i = 0; i < board.size(); i++) {
            if(board.get(x).charAt(i) == 'Q')
                return false;
        }

        // Check vertical
        for(int i = 0; i < board.size(); i++) {
            if(board.get(i).charAt(y) == 'Q')
                return false;
        }

        return true;
    }

    public boolean noQueenDiagonally(List<String> board, int x, int y) {
    int n = board.size();

    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            if(board.get(i).charAt(j) == 'Q') {
                if(Math.abs(i - x) == Math.abs(j - y))
                    return false;
            }
        }
    }

    return true;
}
}
