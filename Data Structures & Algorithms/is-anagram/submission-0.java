class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false; 
        int[] freq = new int[26]; 
        for(char c: t.toCharArray()){
            freq[c - 'a']++; 
        }
        for(char c: s.toCharArray()){
            freq[c - 'a']--; 
            if(freq[c - 'a'] < 0)
                return false; 
        }
        return true; 
    }
}


/* Notes 
freq 
c -> NUMBER

s r if length != return false; 
reuce the counter < 0 return false

[2, 0, 1, ......]

-- n + m
26

*/ 