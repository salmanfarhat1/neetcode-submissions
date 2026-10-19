class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
            return false; 
        return Interleaving(s1, s3) && Interleaving(s2, s3); 
    }
    public boolean Interleaving(String s1, String s2){
        if(s1.length() > s2.length())
            return false; 
        int s1Index = 0; 
        for(int i =0;  i < s2.length(); i++){
            if(s1Index < s1.length() && s1.charAt(s1Index) == s2.charAt(i))
                s1Index++; 
        }

        return s1Index == s1.length(); 
    }   


}
/*Notes:

aaaa 
aabbbbaa

*/