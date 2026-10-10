class PrefixTree {
    PrefixTree[] trie; 
    boolean isWord; 
    public PrefixTree() {
         isWord = false; 
         trie = new PrefixTree[26];
    }

    public void insert(String word) {
        PrefixTree cur = this; 
        for(int i = 0; i < word.length(); i++){
            int charIndex = word.charAt(i) -'a'; 
            if(cur.trie[charIndex] == null)
                cur.trie[charIndex] = new PrefixTree(); 
            
            cur = cur.trie[charIndex]; 
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        PrefixTree cur = this; 
        for(int i = 0; i < word.length(); i++){
            int charIndex = word.charAt(i) -'a'; 
            if(cur.trie[charIndex] == null){
                return false; 
            }
            cur = cur.trie[charIndex]; 
        }
        return cur.isWord; 
    }

    public boolean startsWith(String prefix) {
        PrefixTree cur = this; 
        for(int i = 0; i < prefix.length(); i++){
            int charIndex = prefix.charAt(i) -'a'; 
            if(cur.trie[charIndex] == null){
                return false; 
            }
            if(i == prefix.length() - 1)
                return true; 
            cur = cur.trie[charIndex]; 
        }
        return false; 
    }
}
