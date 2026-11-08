class Solution {
    int counter = 0; 
    public int totalNQueens(int n) {
        //fill path with .... dots
        List<String> board = new ArrayList<>(); 
        String s = "";
        for(int i = 0; i < n; i++)
            s += "."; 
        for(int i = 0; i < n; i++)
            board.add(s); 

        backtrack(n, 0,  board , 0, 0); 
        return counter; 
    }
    public void backtrack(int n, int nQueens, List<String> board,
                      int levelStart, int y){
        if(nQueens == n){
            counter++; 
            return;
        }

        for(int i = y; i < n; i++){

            if(noQueenHorizantallyOrVertically(board, levelStart, i)
            && noQueenDiagonally(board, levelStart, i)){

                char[] row = board.get(levelStart).toCharArray();
                row[i] = 'Q';
                board.set(levelStart, new String(row));

                backtrack(n, nQueens + 1, board, levelStart + 1, 0);

                row[i] = '.';
                board.set(levelStart, new String(row));
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
