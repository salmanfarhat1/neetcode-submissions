class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Character, List<int[]>> map = new HashMap<>();

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == '.') continue;

                List<int[]> arr = map.getOrDefault(board[i][j], new ArrayList<>());
                arr.add(new int[]{i, j});
                map.put(board[i][j], arr);
            }
        }

        boolean result = true;

        for(Map.Entry<Character, List<int[]>> entry : map.entrySet()){
            result = result & checkRowColumn(entry.getValue(), board);
        }

        return result;
    }

    public boolean checkRowColumn(List<int[]> list, char[][] board){
        Set<Integer> setx = new HashSet<>();
        Set<Integer> sety = new HashSet<>();

        for(int i = 0; i < list.size(); i++){
            if(setx.contains(list.get(i)[0])){
                return false;
            }

            if(sety.contains(list.get(i)[1])){
                return false;
            }

            if(!checkBlock(list.get(i)[0], list.get(i)[1], board))
                return false;

            setx.add(list.get(i)[0]);
            sety.add(list.get(i)[1]);
        }

        return true;
    }

    public boolean checkBlock(int x, int y, char[][] board){

        int newX = x;
        int newY = y;

        while(newX % 3 != 0){
            newX--;
        }

        while(newY % 3 != 0){
            newY--;
        }

        for(int i = newX; i < newX + 3; i++){
            for(int j = newY; j < newY + 3; j++){
                if(x != i && y != j)
                    if(board[x][y] == board[i][j])
                        return false;
            }
        }

        return true;
    }
}