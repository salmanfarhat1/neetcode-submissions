class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n == 0)
            return true; 
        HashMap<Integer, List<Integer>> graph = new HashMap<>(); 
        constructGraph(edges, n, graph); 
        if(!everyNodeHasAtLeastOneNeighbor(n, edges))
            return false; 
        
        boolean[] path = new boolean[n];
        boolean[] visited = new boolean[n];         

        dfs(0, graph, -1, path, visited); 

        for(int i = 0; i < n ; i++)
            if(!visited[i])
                return false; 
        return true; 
     
    }

    public boolean dfs(int node, HashMap<Integer, List<Integer>> graph, int parent, boolean[] path, boolean[] visited){
        if(path[node])
            return false; 
        visited[node] = true; 
        path[node] = true;
        List<Integer> neighbors = graph.get(node);
        
        for(int i =0; i < neighbors.size(); i++){
            if(neighbors.get(i) == parent)
                continue; 
            if(!dfs(neighbors.get(i), graph, node, path, visited))
                return false; 
        } 
       
        path[node] = false;

        return true; 

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

        for (int[] edge: edges) {
            List<Integer> listNeighborsIndex0 = graph.get(edge[0]);
            List<Integer> listNeighborsIndex1 = graph.get(edge[1]);
            listNeighborsIndex0.add(edge[1]); 
            listNeighborsIndex1.add(edge[0]); 
            graph.put(edge[0],listNeighborsIndex0); 
            graph.put(edge[1],listNeighborsIndex1); 
        }
    } 
}
