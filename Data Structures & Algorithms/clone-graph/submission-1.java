/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)   return null; 
        HashMap<Node , Node> map = new HashMap<>(); 
        buildNodes(node, map); 
        return map.get(node); 
    }
    public void buildNodes(Node node , HashMap<Node, Node> map){
        Queue<Node> q = new LinkedList<>(); 
        q.add(node);
        while(!q.isEmpty()){
            Node n = q.poll(); 
            Node newNode;  
            if(map.containsKey(n))
                newNode = map.get(n); 
            else
                newNode = new Node(n.val);
            map.put(n, newNode);  
            List<Node> neighbors = n.neighbors;
            for(int i =0 ; i < neighbors.size(); i++){
                Node neighbor = neighbors.get(i);
                if(!map.containsKey(neighbor)){
                    Node newNeighbor = new Node(neighbor.val); 
                    map.put(neighbor,newNeighbor); 
                    q.add(neighbor);
                }
                newNode.neighbors.add(map.get(neighbor));
                
            }
        }
    }
}