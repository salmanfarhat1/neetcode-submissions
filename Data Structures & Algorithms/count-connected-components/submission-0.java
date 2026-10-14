class Solution {
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>(); 
        constructGraph(edges, n, graph); 
        boolean[] visited = new boolean[n]; 
        int SCC = 0; 
        for(int i =0; i < n; i++){
            if(visited[i])
                continue;
            SCC++; 
            dfs(graph, i , visited); 
        }
        return SCC; 
    }
    public void dfs(HashMap<Integer, List<Integer>> graph,  int curNode, boolean[] visited){
        if(visited[curNode] == true)
            return; 
   
        visited[curNode] = true; 

        List<Integer> neighbors = graph.get(curNode); 
        for(int i =0; i < neighbors.size(); i++){
            dfs(graph, neighbors.get(i), visited); 
        }
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
