class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int index = -1;
    }

    public List<String> findWords(char[][] board, String[] words) {

        List<String> result = new ArrayList<>();

        // Build Trie
        TrieNode root = new TrieNode();

        for (int i = 0; i < words.length; i++) {

            TrieNode cur = root;

            for (char c : words[i].toCharArray()) {

                int index = c - 'a';

                if (cur.children[index] == null)
                    cur.children[index] = new TrieNode();

                cur = cur.children[index];
            }

            cur.index = i;
        }

        // DFS from every cell
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                dfs(board, i, j, root, words, result);
            }
        }

        return result;
    }

    public void dfs(
        char[][] board,
        int i,
        int j,
        TrieNode node,
        String[] words,
        List<String> result
    ) {

        // Outside board
        if (i < 0 || i >= board.length ||
            j < 0 || j >= board[0].length)
            return;

        // Already visited
        if (board[i][j] == '#')
            return;

        char c = board[i][j];

        // Does this character exist in the Trie?
        TrieNode next = node.children[c - 'a'];

        if (next == null)
            return;

        // We found a complete word
        if (next.index != -1) {

            result.add(words[next.index]);

            // Don't add the same word again
            next.index = -1;
        }

        // Mark visited
        board[i][j] = '#';

        // Explore neighbors
        dfs(board, i + 1, j, next, words, result);
        dfs(board, i - 1, j, next, words, result);
        dfs(board, i, j + 1, next, words, result);
        dfs(board, i, j - 1, next, words, result);

        // Restore
        board[i][j] = c;
    }
}