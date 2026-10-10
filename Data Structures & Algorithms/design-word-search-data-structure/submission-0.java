class WordDictionary {
    WordDictionary[] alpha;
    boolean isWord; 
    public WordDictionary() {
        alpha = new WordDictionary[26];
        isWord = false; 
    }

    public void addWord(String word) {
        WordDictionary cur = this; 
        for(int i = 0; i < word.length(); i++){
            int charIndex = word.charAt(i) - 'a'; 
            if(cur.alpha[charIndex] == null)
                cur.alpha[charIndex] = new WordDictionary(); 
            cur = cur.alpha[charIndex];
        }
        cur.isWord = true; 
    }
    public boolean searchHelper(WordDictionary cur , String word){
        if(word.equals(""))
            return cur.isWord; 
        
        for(int i =0; i < word.length(); i++){
            int charIndex = word.charAt(i) - 'a';
            if(word.charAt(i) == '.'){
                for(int j =0; j < cur.alpha.length; j++){
                    if(cur.alpha[j] != null){
                        if(searchHelper(cur.alpha[j], word.substring(i + 1)))
                            return true;  
                 
                    }
                }
                return false;
            }
            else{
                if(cur.alpha[charIndex] == null)
                    return false;
                cur = cur.alpha[charIndex]; 
            } 
        }
        return cur.isWord; 
    }
    public boolean search(String word) {
       return searchHelper(this, word); 
    }
}
