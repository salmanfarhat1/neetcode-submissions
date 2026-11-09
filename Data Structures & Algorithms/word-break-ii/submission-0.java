class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>(); 
        backtrack(s, wordDict, 0,  "", result); 
        return result; 
    }
    
    public void backtrack(String s, List<String> wordDict, int startIndex, String sentence, List<String> result){
        if(startIndex == s.length()){
            result.add(sentence.substring(1));
            return;
        }

        for(int i = startIndex; i < s.length(); i++){
            String curWord = s.substring(startIndex, i + 1);
            if(!checkIfWordInDict(curWord, wordDict))
                continue; 
            backtrack(s, wordDict, i + 1, sentence + " " + curWord, result);
        }

    }
    public boolean checkIfWordInDict(String word, List<String> wordDict){
        for(int i= 0; i < wordDict.size(); i++ ){
            if(wordDict.get(i).equals(word))
                return true; 
        }
        return false; 
    } 
}
