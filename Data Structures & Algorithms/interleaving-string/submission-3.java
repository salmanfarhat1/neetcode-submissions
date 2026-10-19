class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
            return false; 
        HashMap<String, Boolean> memo = new HashMap<>(); 
        return backtrack(s1, s2, s3, 0, 0, memo); 
    }
    public boolean backtrack(String s1, String s2, String s3, int index1, int index2, HashMap<String, Boolean> memo) {
        
        if(index1 + index2 == s3.length())
            return true; 
        String key = index1 + "-"+ index2; 

        if(memo.containsKey(key))
            return memo.get(key); 

        if(index1 < s1.length() && index2 < s2.length() && s1.charAt(index1) != s3.charAt(index1 + index2) && 
           s2.charAt(index2) != s3.charAt(index1 + index2)){
            return false; 
        } 
        boolean result1 = false, result2 = false; 
        if(index1 < s1.length() && s1.charAt(index1) == s3.charAt(index1 + index2)){
            result1 = result1 || backtrack(s1,s2,s3, index1 + 1, index2, memo );

        }
        if(index2 < s2.length() && s2.charAt(index2) == s3.charAt(index1 + index2)){
            result2 = result2 || backtrack(s1,s2,s3, index1, index2 + 1, memo);
        }

        memo.put(key , result1 || result2); 
        return result1 || result2; 
        
    }
    

}
/*Notes:
s1: aabd  s2: abdc s3 : aabdbadc
brute force way: put all the combinations of s1 with s2 and compare it to s3
0 0 
0 1 || 1 0 

0 2 || 1 1 || 1 1 || 2 1 

0 3 || 1 2 || 1 2 || 2 1 || 2 2 || 3 2 


repeating work as we can see to avoid it I would use memo  wirth index1 and index2 
*/