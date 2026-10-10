class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s.length() == 1)
            return s.length();
        Set<Character> set = new HashSet<>();   
        int max =  0; 
        int left = 0; 
        for(int right = 0; right < s.length(); right++){
            if(set.contains(s.charAt(right))){
                max = Math.max(max , right - left);
                while(left <= right){
                    if(s.charAt(left) == s.charAt(right)){
                        break;
                    }
                    left++; 
                }
                left++; 
                set.remove(s.charAt(right)); 
            }
            if(right == s.length() - 1 ){
                max = Math.max(max, right - left + 1);
            }
            set.add(s.charAt(right));
        }
        return max; 
    }
}
