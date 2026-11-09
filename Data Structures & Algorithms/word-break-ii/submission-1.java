
class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();

        TrieNode root = new TrieNode();

        // Build Trie
        for(String word : wordDict) {
            insert(root, word);
        }

        backtrack(s, root, 0, "", result);

        return result;
    }

    public void insert(TrieNode root, String word) {
        TrieNode node = root;

        for(char c : word.toCharArray()) {
            int index = c - 'a';

            if(node.children[index] == null)
                node.children[index] = new TrieNode();

            node = node.children[index];
        }

        node.isWord = true;
    }

    public void backtrack(String s, TrieNode root, int startIndex,
                          String sentence, List<String> result) {

        if(startIndex == s.length()) {
            result.add(sentence.trim());
            return;
        }

        TrieNode node = root;

        for(int i = startIndex; i < s.length(); i++) {

            int index = s.charAt(i) - 'a';

            // No possible word with this prefix
            if(node.children[index] == null)
                break;

            node = node.children[index];

            // We found a valid word
            if(node.isWord) {
                String curWord = s.substring(startIndex, i + 1);

                backtrack(s, root, i + 1,
                          sentence + " " + curWord, result);
            }
        }
    }
}
