class Solution {
    public int numDistinct(String s, String t) {
        HashMap<String, Integer> memo = new HashMap<>(); 
        if(s.length() == 0 && t.length() == 0)
            return 1;
        return backtrack(s, t, 0, 0,memo);
    }

    public int backtrack(String s, String t, int indexS, int indexT, HashMap<String, Integer> memo){
        if(t.length() == indexT)
            return 1; 
        if(s.length() == indexS)
            return 0; 
        String key = indexS + "-" +indexT; 
        if(memo.containsKey(key))
            return memo.get(key); 
        
        int result1 = 0;
        if(s.charAt(indexS) == t.charAt(indexT)){
            result1 += backtrack(s,t,indexS + 1, indexT+1, memo); 
        }
        result1 += backtrack(s, t, indexS+ 1, indexT, memo); 
        memo.put(key ,result1);
        return result1; 
    }
}




/*Notes: 
caaat - cat 
        caaat


        I can consider dp[i][j] = number of distict subseq of s which are equal to t
        dp[s.length][t.length] = 0;
        dp[i][j] =  if(s.charAT(i) == t.charAT[j]) dp[i][j] = dp[i +1][j +1]
            if not equal


    solve it using backyrackong 
    c == c take it or leftit 

    call index 1 + 1 index 2 + 2 
    aaat at

    aaat cat -> aat cat at cat 

    aat t
    aat at 
    at at
    t


    when to stop if the the length of s is empty or t is empty increment a global counter
*/ 