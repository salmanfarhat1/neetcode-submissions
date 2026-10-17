class Solution {
    public String longestPalindrome(String s) {
        String maxHolder = ""; 
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                String sub = s.substring(i , j); 
                if(isPalindrom(sub))
                    if(maxHolder.length() < sub.length())
                        maxHolder = s.substring(i,j);
            }
        }
        return maxHolder;
    
    }

    public boolean isPalindrom(String s){
        for(int i = 0; i < s.length()/2 ; i++){
            if(s.charAt(i ) != s.charAt(s.length() - 1 - i) )
                return false;
        }
        return true;
    } 
}


/* Notes: 
ababd

a max = 1 
ababd
bab
abd



another solution n square start from each one and work it throught
ababd
babd
o(n power 2)



*/