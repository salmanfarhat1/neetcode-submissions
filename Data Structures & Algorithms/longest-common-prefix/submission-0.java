class Solution {
    public String longestCommonPrefix(String[] strs) {
        String s = strs[0];
        String prefix = ""; 
        for(char c : s.toCharArray()){
            prefix += c;
            boolean flag = true; 
            for(int i = 0; i < strs.length; i++){
                if(!strs[i].startsWith(prefix)){
                    flag = false; 
                    break;
                }
            }
            if(flag == false)
                break;
        }
        return prefix.substring(0, prefix.length() -1);
    }
}