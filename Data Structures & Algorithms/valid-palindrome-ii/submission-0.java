class Solution {
    public boolean validPalindrome(String s) {
        boolean used = false; 
        for(int i = 0; i < s.length() / 2; i++){
            char c1 = s.charAt(i); 
            char c2 =  s.charAt(s.length() -1 -i);
            if(c1 != c2 && used){
                return false; 
            }
            else if(c1 != c2 && !used){
                used = true;  
            }
        }
        return true; 
    }
}