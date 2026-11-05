/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}


psuedo code will be: 


helper Node -> node(isLeaf : 0 | 1 ) 
    Node parentNode = new Node
    Node topleft
    ... 
    Node topright 
    if(all are leaf and same val)
        parent Node isleft = true; 
        val = val; 
        childer = null
    parentnode.val = "0"
    return parentNode
*/

class Solution {
    public Node construct(int[][] grid) {
        int n = grid.length;
        return constructQuadTreeHelper(grid, 0, 0, n);
    }

    public Node constructQuadTreeHelper(int[][] grid, int startX, int startY, int size) {
        if(size == 1){
            return new Node((grid[startX][startY] == 1), true); 
        }
        Node parentNode = new Node(); 
        int n = size/2; 

        Node topLeft = constructQuadTreeHelper(grid, startX, startY, n);
        Node topRight = constructQuadTreeHelper(grid, startX, startY + n, n);
        Node bottomLeft = constructQuadTreeHelper(grid, startX + n, startY, n);
        Node bottomRight = constructQuadTreeHelper(grid, startX + n , startY+ n, n);
                // topLeft
                // topRight
                // bottomLeft
                // bottomRight

        if((topLeft.val ==true && topRight.val ==true && 
            bottomLeft.val ==true && bottomRight.val ==true
            && topLeft.isLeaf ==true && topRight.isLeaf ==true && 
            bottomLeft.isLeaf ==true && bottomRight.isLeaf ==true
            ) 
            || (topLeft.val ==false && topRight.val ==false && 
                bottomLeft.val ==false && bottomRight.val ==false && 
                topLeft.isLeaf ==true && topRight.isLeaf ==true && 
                bottomLeft.isLeaf ==true && bottomRight.isLeaf ==true
        )){
                parentNode.val = topLeft.val;
                parentNode.isLeaf = true; 
                topLeft = null;
                topRight = null; 
                bottomLeft = null; 
                bottomRight = null; 
                return parentNode;
        }

        parentNode.topLeft = topLeft;
        parentNode.topRight = topRight;
        parentNode.bottomLeft = bottomLeft;
        parentNode.bottomRight = bottomRight;

        return parentNode; 
        

    }




















}