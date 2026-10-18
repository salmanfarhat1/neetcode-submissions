class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<Integer, Boolean> memo = new HashMap<>(); 
        return backtrack(wordDict, s , 0, memo); 
    }

    public boolean backtrack(List<String> wordDict , String s, int start, HashMap<Integer, Boolean> memo){

        if(start == s.length()){
            return true; 
        }

        if(start > s.length())
            return false; 

        if(memo.containsKey(start))
            return memo.get(start);

        memo.put(start, false);

        for(int i = 0 ; i < wordDict.size(); i++){
            String remaining = s.substring(start); 
            String word = wordDict.get(i);
            if(remaining.startsWith(wordDict.get(i))){
                if(backtrack(wordDict, s, start + word.length() , memo)){
                    memo.put(start, true);
                    return true; 
                } 
            }
        }
         
        return false;
    }
}
