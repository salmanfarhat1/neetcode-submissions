class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;
        
        int[] freq = new int[26 ];
        for(char c: s1.toCharArray()){
            freq[c - 'a']++; 
        }
        int left = 0; 

        for(int right  = 0; right  < s2.length(); right++){
            char c = s2.charAt(right);
            freq[c - 'a']--; 

            if(right + left + 1 > s1.length()){
                freq[s2.charAt(left) -'a']++; 
                left++; 
            }

            if(right - left + 1 == s1.length()){
                boolean result = true;
                for(int i = 0; i < 26 ; i++){
                    if(freq[i] != 0 )
                        result = false; 
                }
                if(result == true)
                    return true; 
            }

            
        }
        
        return false;
    }
}

  