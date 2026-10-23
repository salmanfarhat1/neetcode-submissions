class Solution {
    public boolean checkValidString(String s) {
        int open = 0; 
        int close = 0; 
        int stars = 0; 

        for(char ch : s.toCharArray()){
            if(ch == '(')
                open++; 
            else if(ch == ')')
                close++; 
            else if(ch == '*')
                stars++;
            
            if(close > open && stars + open < close)    
                return false;
            
        } 

        return (close + stars) >= open ; 

        
    }
}


/*     ->    brute force is: when we have * we go in 3 directions open close or equal; 
    
        opens = 2
        close = 1
        curStar = 2

         return close + stars >= open 
        
        2 

        */
