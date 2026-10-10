class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String > map = new HashMap<>(); 
        map.put('2', "abc"); 
        map.put('3', "def"); 
        map.put('4', "ghi"); 
        map.put('5', "jkl"); 
        map.put('6', "mno"); 
        map.put('7', "pqrs"); 
        map.put('8', "tuv"); 
        map.put('9', "wxyz"); 

        List<String> result = new ArrayList<>(); 
        
        if(digits.equals(""))
            return result; 
        result.add("");
        for(char c: digits.toCharArray()){
            
            result = getCombination(map.get(c), result); 
        }
        return result; 
    }
    public List<String> getCombination(String s, List<String> result){
        
        List<String> newResult = new ArrayList<>(); 
        
        for(int i = 0 ; i < s.length(); i++){
            for(int j = 0; j < result.size(); j++){
                newResult.add( result.get(j) + s.charAt(i) ); 
            } 
        }
        return newResult; 
    }
}
