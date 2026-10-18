class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return backtrack(wordDict, s , 0, ""); 
    }
    public boolean backtrack(List<String> wordDict , String s, int wordDictIndex, String sb){
        if(sb.equals(s))
            return true; 

        if(!sb.equals(s.substring(0, sb.length())))
            return false; 

        if(sb.length() > s.length())
            return false; 
        
        for(int i = wordDictIndex ; i < wordDict.size(); i++){
            System.out.println(sb + wordDict.get(i));
            if(!backtrack(wordDict , s, i , sb + wordDict.get(i)))
                continue; 
        }
        return true;
    }
}
