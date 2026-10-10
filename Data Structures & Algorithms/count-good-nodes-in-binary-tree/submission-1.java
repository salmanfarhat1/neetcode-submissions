/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        return goodNodesHelper(root, -101);
    
    }
    public int goodNodesHelper(TreeNode root, int max){
        if(root == null)
            return 0 ; 
        int counter = 0; 
        if(root.val >= max ){
            max = root.val; 
            counter = 1;
        }

        counter += goodNodesHelper(root.left , max);
        counter += goodNodesHelper(root.right, max);
        return counter; 
    } 
}
