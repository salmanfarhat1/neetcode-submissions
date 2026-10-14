class Solution {
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>(); 
        constructGraph()
        if(!everyNodeHasAtLeastOneNeighbor(int n, edges))
            return false; 
        
        for(int i = 0; i < n; i++){
            if(!dfs())
        } 
    }


    public boolean everyNodeHasAtLeastOneNeighbor(int n, int[][] edges){
        Set<Integer> checked = new HashSet<>(); 
        for(int[] edge: edges){
            checked.add(edge[0]);
            checked.add(edge[1]);
        }
        return checked.size() == n; 
    }
    
    public void constructGraph(int[][] edges,
                               int n,
                               HashMap<Integer, List<Integer>> graph) {
        for (int i = 0; i < n; i++)
            graph.put(i, new ArrayList<>());
        // 0, 1 
        for (int[] edge: edges) {
            List<Integer> listNeighborsIndex0 = graph.get(edge[0]);List<Integer> listNeighborsIndex0 = graph.get(edge[0]);
        }
    } 
}
