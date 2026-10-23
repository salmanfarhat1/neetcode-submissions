class Solution {
    class Transition{
        int w; 
        int nodeVal; 
        public Transition(int node, int w  ){
            this.w = w; 
            this.nodeVal = node;
        } 
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<Transition>> graph = new HashMap<>(); 
        constructGraph(times, n ,graph); 
        int[] visited = new int[n + 1];
        Arrays.fill(visited, Integer.MAX_VALUE); 
        Queue<Integer> q = new LinkedList<>(); 
        visited[k] = 0;
        q.add(k);
        while(!q.isEmpty()){
            int curNode = q.poll(); 
            List<Transition> neighbors = graph.get(curNode); 

            for(int i = 0; i < neighbors.size(); i++){
                int w = neighbors.get(i).w; 
                int v = neighbors.get(i).nodeVal; 
                int newCost = visited[curNode] + w; 
                if(newCost < visited[v] ){
                    visited[v] = newCost; 
                     q.add(v);
                }
                
            }
        

        }  
        int maxCost= 0; 
        for(int i = 1; i < n +1; i++){
            maxCost = Math.max(maxCost, visited[i]);
            if(visited[i] == Integer.MAX_VALUE){
                return -1;
            }
        }
        return maxCost;
    }

    public void constructGraph(int[][] times, int n, HashMap<Integer, List<Transition>> graph){
        for(int i =1; i <= n ; i++ )
            graph.put(i, new ArrayList<>());
        for(int i =0 ; i < times.length; i++)
        {
            int u = times[i][0]; 
            int v = times[i][1]; 
            int w = times[i][2];
            List<Transition> neighbors = graph.get(u); 
            neighbors.add(new Transition(v, w)); 
            graph.put(u, neighbors); 
        } 
    }
}