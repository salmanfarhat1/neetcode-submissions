class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0)
            return true; 
        HashMap<Integer, List<Integer>> graph = new HashMap<>(); 
        constructGraph(prerequisites, numCourses, graph); 
        boolean result = true; 
        for(int i =  0; i < numCourses; i++){
            result &= checkCycle(graph, i);
            if(result == false)
                return false;  
        }
        return true; 

    }
    public boolean checkCycle(HashMap<Integer, List<Integer>> graph, int course){
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>(); 
        q.add(course);
        int flag = 0; 
        while(!q.isEmpty()){
            int curCourse = q.poll(); 
            List<Integer> pq = graph.get(curCourse); 
            for(int i = 0; i < pq.size(); i++){
                if(pq.get(i) == course)
                    return false;
                if(!set.contains(pq.get(i))){
                    set.add(pq.get(i)); 
                    q.add(pq.get(i));
                }
            }
            flag = 1; 
        }
        return true;
    }
    public void constructGraph(int[][] prerequistes, int numCourses, HashMap<Integer, List<Integer>> graph){
        for(int i = 0; i < numCourses; i++)
            graph.put(i, new ArrayList<>()); 
        for(int[] dep : prerequistes ){
            List<Integer> neighbors = graph.get(dep[0]); 
            neighbors.add(dep[1]);
            graph.put(dep[0], neighbors); 
        }
    }
}
