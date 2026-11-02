class Solution {
    public String mergeAlternately(String word1, String word2) {
        int index1 = 0; 
        int index2 = 0;
        String result = ""; 

        while(index1 < word1.length() || index2 < word2.length()){
            String c1 = (index1 < word1.length()) ? word1.charAt(index1) + "" : "";
            String c2 = (index2 < word2.length()) ? word2.charAt(index2) + "": "";

            result += c1 + c2; 
            index1++; 
            index2++; 
        }
        return result; 
    }
}