class Solution {
    public String minWindow(String s, String t) {
        int[] freqLower = new int[26];
        int[] freqUpper = new int[26];

        for(char c: t.toCharArray()){
            if('A' <= c && c <= 'Z')
                freqUpper[c - 'A']++; 
        }
        for(char c: t.toCharArray()){
            if('a' <= c && c <= 'z')
                freqLower[c - 'a']++; 
        }
        int min = Integer.MAX_VALUE; 
        String holder = "";
        int left = 0; 
        
        for(int right = 0; right < s.length(); right++ ){
            char c = s.charAt(right);
            if('A' <= c && c <= 'Z')
                freqUpper[c - 'A']--; 
            else{
                freqLower[c - 'a']--;
            } 

            if(containsT(freqLower, freqUpper)){
                while(containsT(freqLower, freqUpper)){
                    int curMin = right - left + 1;
                    if(curMin < min){
                        min = curMin; 
                        holder = s.substring(left, right + 1); 
                    }
                    char ch = s.charAt(left);
                    if('A' <= ch && ch <= 'Z')
                        freqUpper[ch - 'A']++; 
                    else
                        freqLower[ch - 'a']++; 
                    
                    left++; 
                }
            }
            
        }

        return holder;

    }
    public boolean containsT(int[] freqLower, int[] freqUpper){
        for(int i =0; i < 26; i++){
            if(freqLower[i] > 0)
                return false;
        }
        for(int i =0; i < 26; i++){
            if(freqUpper[i] > 0)
                return false;
        }  
        return true; 
    } 
}


/*Notes: 
0 .... 1 1 1

1 1 1 1 1 0 1 1 
5  a z o d 

*/ 