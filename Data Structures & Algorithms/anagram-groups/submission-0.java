class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String> > map = new HashMap<>(); 

        for(int i =0; i < strs.length; i++ ){
            char[] chars = strs[i].toCharArray(); 
            Arrays.sort(chars);
            String s = new String(chars);
            List<String> list = map.getOrDefault(s, new ArrayList<>());
            list.add(strs[i]); 
            map.put(s, list);  
        }

        List<List<String>> res = new ArrayList(); 
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            res.add(entry.getValue());  
        }
        return res; 
    }
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false; 
        int[] freq = new int[26]; 
        for(char c: t.toCharArray()){
            freq[c - 'a']++; 
        }
        for(char c: s.toCharArray()){
            freq[c - 'a']--; 
            if(freq[c - 'a'] < 0)
                return false; 
        }
        return true; 
    }
}

