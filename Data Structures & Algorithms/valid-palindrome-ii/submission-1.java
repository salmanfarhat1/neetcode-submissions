class Solution {
    boolean used = false;
    public boolean validPalindrome(String s) {
       return validPalindromeHelper(s , 0 , s.length() -1); 
    }
    public boolean validPalindromeHelper(String s, int left, int right){
        while(left < right){
            char c1 = s.charAt(left); 
            char c2 = s.charAt(right); 
            if(c1 == c2){
                return validPalindromeHelper(s, left + 1, right -1);
            }
            else if(c1 != c2 && !used){
                used = true; 
                return validPalindromeHelper(s, left + 1, right) || validPalindromeHelper(s, left, right - 1 );
            }
            else{
                return false; 
            }
        }
        return true; 
    }
}