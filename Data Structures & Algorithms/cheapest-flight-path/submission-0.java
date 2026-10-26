class Solution {
    class Transition{
        int cityNo; 
        int cost; 
        public Transition(int cityNo, int cost){
            this.cityNo = cityNo; 
            this.cost = cost; 
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, List<Transition>> graph = constructGraph(flights, n);
        boolean[] visited = new boolean[n]; 
        int result = dfs(graph, src, dst, k, visited);
        return ( result == 0 && src != dst) ? -1 : result; 
    }
    public int dfs(HashMap<Integer, List<Transition>> graph, int src, int dst, int k, boolean[] visited){
        if(k < 0 && src != dst )
            return -1;  

        if(visited[src])
            return -1;
        
        if(k >= 0 && src == dst)
            return 0;
        
        visited[src] = true; 
        
        List<Transition> neighbors = graph.get(src); 
        int result = 0; 
        for(int i = 0; i < neighbors.size(); i++){
            int result1 = neighbors.get(i).cost + dfs(graph, neighbors.get(i).cityNo, dst, k -1, visited); 
            if(result1 == -1)
                continue;
            result = Math.max(result, result1); 
            visited[src] = false; 
        }

        return result; 
    }


    public HashMap<Integer, List<Transition>> constructGraph(int[][] flights, int n){
        HashMap<Integer, List<Transition>> graph = new HashMap<>(); 
        for(int i =0; i < n; i++){
            graph.put(i, new ArrayList<>()); 
        }
        for(int i = 0; i < flights.length; i++){
            int src = flights[i][0]; 
            int dst = flights[i][1];  
            int cost = flights[i][2];
            List<Transition> neigh = graph.get(src); 
            neigh.add(new Transition(dst, cost)); 
        }
        return graph; 
    }
    

         
}
