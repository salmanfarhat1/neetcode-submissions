class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0; 
        int count = 0;
        int max= 0; 
        HashMap<Character, Integer> map = new HashMap<>(); 
        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right); 
            if(!map.containsKey(c)){
                map.put(c, 1); 
            }
            else{ 
                if(count < k){
                    map.put(c, map.get(c) + 1); 
                    count++; 
                }
                else{
                    max = Math.max(right - left , max);
                    while(left <= right && count >= k){
                        char ch = s.charAt(left); 
                        int occ = map.getOrDefault(ch, 0); 
                        if(occ > 1 ){
                            count--;
                        }
                        map.put(ch , occ - 1); 
                        left++;
                    } 
                }
            }
        } 
        return Math.max(max, s.length() - left); 
    }
}

/*Notes: 


*/ 
