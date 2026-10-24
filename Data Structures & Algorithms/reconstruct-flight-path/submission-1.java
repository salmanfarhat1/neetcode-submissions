class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String , PriorityQueue<String>> graph = new HashMap<>(); 
        constructGraph(tickets, graph);
        Set<String> visited = new HashSet<>();
        List<String> path = new ArrayList<>(); 
        dfs(graph, "JFK",  path, visited); 
         Collections.reverse(path); 
         return path; 
    }   
    public void dfs(HashMap<String, PriorityQueue<String>> graph, String city,List<String> path, Set<String> visited ){

        
        PriorityQueue<String> neighbors = graph.get(city);
        while(neighbors != null && !neighbors.isEmpty()){
            String neighbor = neighbors.poll(); 
            String flight = city+"-"+neighbor; 
            if(visited.contains(flight))
                continue; 
            visited.add(flight);
            dfs(graph , neighbor, path, visited);  
        }
        path.add(city); 
    }
    public void constructGraph(List<List<String>> tickets, HashMap<String, PriorityQueue<String>> graph){
        Set<String> set = new HashSet<>();
        for(int i = 0; i < tickets.size(); i++){
            String u = tickets.get(i).get(0);
            String v = tickets.get(i).get(1);
            PriorityQueue<String> pq = new PriorityQueue<>(
                (a,b) -> {
                        return a.compareTo(b); 
                }
            ); 
            pq = graph.getOrDefault(u, pq); 
            pq.add(v);
            graph.put(u, pq);
        }
    }
}
