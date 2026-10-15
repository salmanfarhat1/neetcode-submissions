class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>(); 
        int n = edges.length + 1; 
        for(int i =0; i < n; i++) // create all nodes with empty neighbors
            graph.put(i, new ArrayList<>());
        
        for(int[] edge: edges){
            addEdgeToGraph(graph, edge);
            boolean[] visited = new boolean[n]; 
            boolean[] path = new boolean[n]; 
            if(containCycle(graph, edge[0], visited,  path, -1 ))
                return edge;
        } 
        return null;
    }
    public boolean containCycle(HashMap<Integer, List<Integer>> graph,
                                int curNode, boolean[] visited, 
                                boolean[] path, int parent
                                ){
        if(path[curNode])
            return true;
        if(visited[curNode])
            return false;
        visited[curNode] = true; 
        path[curNode] = true; 
        List<Integer> neigh = graph.get(curNode);  
        for(int i = 0; i < neigh.size(); i++){
            if(neigh.get(i) == parent) continue; 
            if(containCycle(graph, neigh.get(i), visited, path , curNode))
                return true;
        }

        path[curNode] = false;
        return false; 
        
    }


    public void addEdgeToGraph(HashMap<Integer, List<Integer>> graph , int[] edge){
        List<Integer> node1Neighb = graph.getOrDefault(edge[0], new ArrayList<>()); 
        List<Integer> node2Neighb = graph.getOrDefault(edge[1], new ArrayList<>()); 
        node1Neighb.add(edge[1]);
        node2Neighb.add(edge[0]); 
        graph.put(edge[0], node1Neighb);
        graph.put(edge[1], node2Neighb); 
    }
}
