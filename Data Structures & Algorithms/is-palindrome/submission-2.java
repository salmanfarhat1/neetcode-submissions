class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase(); 
        int left = 0 ; 
        int right = s.length() - 1; 


        while(left < right){
            while(left < right && left < s.length() -1)
                left++; 
            while(left < right && right>= 0 )
                right--; 
            if(left > right)
                return true; 
            if(s.charAt(left) != s.charAt(right)){
                // System.out.println(s.charAt(left) + " ---------- " + s.charAt(right) ); 
                return false;
            }
            left++; 
            right--; 
        }
        return true; 
    }
}
