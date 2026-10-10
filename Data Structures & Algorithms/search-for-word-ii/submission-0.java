class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>(); 
        for(int i =0; i < words.length ;i++){
            if(exist(board, words[i]))
                result.add(words[i]); 
        }
        return result; 
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        boolean result = false;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                result = result | dfs(board,word, visited, i, j, 0);
                if(result)
                    return true;
            }
        }

        return result;
    }

    public boolean dfs(
        char[][] board,
        String word,
        boolean[][] visited,
        int i,
        int j,
        int curIndex
    ) {
        if(i >= board.length || j >= board[0].length ||
           i < 0 || j < 0)
            return false;
        if(visited[i][j])
            return false;
        if(board[i][j] != word.charAt(curIndex))
            return false;
        if(curIndex == word.length() - 1)
            return true;
        visited[i][j] = true;
        int[] xs = new int[]{0, 0, 1, -1};
        int[] ys = new int[]{1, -1, 0, 0};
        boolean result = false;
        for(int k = 0; k < 4; k++){
            int newx = xs[k] + i;
            int newy = ys[k] + j;
            if(newx < 0 || newx >= board.length ||
               newy < 0 || newy >= board[0].length)
                continue;
            result = result | dfs(board,word,visited,newx,newy,curIndex + 1);
            if(result)
                break;
        }
        visited[i][j] = false;
        return result;
    }
}