
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> curBoard = new ArrayList<>();

        String s = "";
        for (int i = 0; i < n; i++) {
            s += ".";
        }

        for (int i = 0; i < n; i++) {
            curBoard.add(s);
        }

        backtrack(n, 0, curBoard, result);
        return result;
    }

    public void backtrack(
        int n,
        int row,
        List<String> curBoard,
        List<List<String>> result
    ) {
        if (row == n) {
            if (verify(curBoard)) {
                result.add(new ArrayList<>(curBoard));
            }
            return;
        }

        for (int col = 0; col < n; col++) {
            char[] chars = curBoard.get(row).toCharArray();
            chars[col] = 'Q';
            curBoard.set(row, new String(chars));

            if (verify(curBoard)) {
                backtrack(n, row + 1, curBoard, result);
            }

            chars[col] = '.';
            curBoard.set(row, new String(chars));
        }
    }

    public boolean verify(List<String> board) {
        int n = board.size();
        List<int[]> positionsQ = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String row = board.get(i);

            for (int j = 0; j < n; j++) {
                if (row.charAt(j) == 'Q') {
                    positionsQ.add(new int[]{i, j});
                }
            }
        }

        int[] freq = new int[n];

        for (int[] pos : positionsQ) {
            if (freq[pos[0]] != 0) {
                return false;
            }
            freq[pos[0]]++;
        }

        Arrays.fill(freq, 0);

        for (int[] pos : positionsQ) {
            if (freq[pos[1]] != 0) {
                return false;
            }
            freq[pos[1]]++;
        }

        int[][] directions = {
            {1, 1}, {-1, -1}, {-1, 1}, {1, -1}
        };

        for (int[] pos : positionsQ) {
            for (int[] dir : directions) {
                int x = pos[0] + dir[0];
                int y = pos[1] + dir[1];

                while (x >= 0 && x < n && y >= 0 && y < n) {
                    if (board.get(x).charAt(y) == 'Q') {
                        return false;
                    }

                    x += dir[0];
                    y += dir[1];
                }
            }
        }

        return true;
    }
}