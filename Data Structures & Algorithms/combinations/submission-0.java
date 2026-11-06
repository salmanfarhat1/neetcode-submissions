class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();  
        backtrack(n, k, 1, new ArrayList<>(), result); 
        return result; 
    }
    public void backtrack(int n, int k, int index, List<Integer> path, List<List<Integer>> result){
        if(path.size() == k)
        {
            result.add(new ArrayList<>(path)); 
            return; 
        } 
        for(int i = index; i <=  n ; i++){
            path.add(i); 
            backtrack(n,k,i +1, path, result); 
            path.remove(path.size() - 1);  
        }
    } 
}