/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node cur = head;
        Node newHead = new Node(-1);
        Node cur2 = newHead;
        HashMap<Node, Node> map = new HashMap(); 
        while(cur != null){
            Node newNode = new Node(cur.val); 
            cur2.next = newNode; 
            map.put(cur, newNode); 
            cur = cur.next; 
            cur2 = cur2.next; 
        }
        cur = head;
        cur2 = newHead.next; 
        
        while(cur != null){
            cur2.random = (cur.random == null) ? null : map.get(cur.random);
            cur = cur.next; 
            cur2 = cur2.next; 
        } 
        return newHead.next; 
    }
}
