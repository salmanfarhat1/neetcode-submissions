class Solution {
    public String foreignDictionary(String[] words) {
        HashMap<Character, List<Character>> graph = new HashMap<>(); 

        String prev = words[0];
        for(int i = 1; i < words.length; i++){
            String cur = words[i]; 
            int j = 0, k = 0; 
            while(j < prev.length() && k < cur.length() && prev.charAt(j) == cur.charAt(k)){
                j++; k++; 
            }
            if(j >= prev.length() || k >= cur.length())
                continue; 
            List<Character> neighbors = graph.getOrDefault(prev.charAt(j) , new ArrayList<>()); 
            neighbors.add(cur.charAt(k)); 
            graph.put(prev.charAt(j), neighbors);
            prev = cur;
        }

        String result = "";
        for(Map.Entry<Character, List<Character>> entry : graph.entrySet()){
            boolean[] visited = new boolean[26]; 
            String result1 = dfs(graph, entry.getKey(), visited); 
            if(result1.length() == 0)
                return "";
            else{
                if(result1.length() > result.length())
                    result = result1;
            }

        }
        return result; 
    }
    public String dfs(HashMap<Character, List<Character>> graph , char c, boolean[] visited){
        if(visited[c - 'a'])
            return ""; 
        visited[c-'a'] = true; 
        List<Character> neighbors = graph.getOrDefault(c, new ArrayList<>()); 
        String result = c + "";
        
        for(int i = 0; i < neighbors.size(); i++){
            char neigh = neighbors.get(i); 
            if(visited[ neigh - 'a'])
                return "";
            result = result +  dfs(graph, neigh, visited); 
        }

        return result; 
    }
}
