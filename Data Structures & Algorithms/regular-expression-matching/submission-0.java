class Solution {
    public boolean isMatch(String s, String p) {
        HashMap<String, Boolean> memo = new HashMap<>(); 
        return backtrack(s, p, 0, 0, memo);
    }

    public boolean backtrack(String s, String p, int index1, int index2,HashMap<String, Boolean> memo ) {
        if (index1 == s.length() && index2 == p.length())
            return true;

        if (index2 == p.length())
            return false;
        
        String key = index1 + "-" + index2; 
        if(memo.containsKey(key))
            return memo.get(key); 

        boolean result1 = false, result2 = false, result3 = false;

        if (index2 + 1 < p.length() && p.charAt(index2 + 1) == '*') {
            // Zero occurrences
            result1 = backtrack(s, p, index1, index2 + 2, memo);

            // One or more occurrences
            while (index1 < s.length() &&
                   (s.charAt(index1) == p.charAt(index2) ||
                    p.charAt(index2) == '.')) {
                index1++;
                result3 |= backtrack(s, p, index1, index2 + 2, memo);
            }
        } else {
            if (index1 < s.length() &&
                (s.charAt(index1) == p.charAt(index2) ||
                 p.charAt(index2) == '.')) {
                result2 = backtrack(s, p, index1 + 1, index2 + 1, memo);
            }
        }
        memo.put(key , result1 || result2 || result3);
        return result1 || result2 || result3;
    }
}