class Solution {
    public String longestPalindrome(String s) {
        return helper(s , 0 , s.length() - 1); 
    }

    public String helper(String s, int start, int end){
        if(start == end){
            return s.substring(start, end); 
        }
        String sub = s.substring(start , end ); 
        if(isPalindrom(sub))
            return sub; 

        String left = helper(s, start, end -1); 
        String right = helper(s,  start + 1, end); 

        return (left.length() > right.length()) ? left : right; 
    }



    public boolean isPalindrom(String s){
        for(int i = 0; i < s.length()/2 ; i++){
            if(s.charAt(i ) != s.charAt(s.length() - 1 - i) )
                return false;
        }
        return true;
    } 
}


/* Note: 

ababd

    ababd ? no 
left  || right 
abab        babd
yes stop  || no  ----- > O(2 power n)) time complexity brute force 



*/ 