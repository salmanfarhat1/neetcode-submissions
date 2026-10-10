class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;
        s1 = sort(s1); 

        for(int i = 0; i < s2.length() - s1.length(); i++){
            String s2SubString = s2.substring(i, i + s1.length());
            s2SubString = sort(s2SubString);  
            if(s2SubString.equals(s1))
                return true;
        }
        return false;
    }
    public String sort(String s){
        char[] sSubString = s.toCharArray(); 
        Arrays.sort(sSubString);
        return new String(sSubString); 
    }
}
