class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>(); 
        backtrack(s, new ArrayList<>(), 0, result);
        return result; 
    }
    public boolean isPlandrom(String s){
        for(int i =0; i < s.length()/2; i++)
        {
            if(s.charAt(i) != s.charAt(s.length() -1 -i))
                return false;
        } 
        return true; 
    }
    public void backtrack(String s, List<String> path, int index, List<List<String>> result ){
        if(index == s.length()){
            result.add(new ArrayList<>(path)); 
            return; 
        }

        for(int end = index + 1; end <= s.length(); end++  ){
            String substring = s.substring(index, end); 
            if(!isPlandrom(substring))
                continue;

            path.add(substring);
            backtrack(s, path, end, result); 
            path.remove(path.size() - 1 );   
        }
    } 
}
