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
    public int rob(TreeNode root) {
        
        if(root == null)
            return 0; 
        if(root.left == null && root.right == null)
            return root.val; 
        
        int takeChildren = rob(root.left) + rob(root.right); 

        int takeCurRoot = root.val; 
        if(root.left != null && root.left.left != null )
             takeCurRoot = takeCurRoot + rob(root.left.left) + rob(root.left.right); 
        if(root.right != null && root.right.right != null )
             takeCurRoot =takeCurRoot+  rob(root.right.right) + rob(root.right.left); 
        
        return Math.max(takeChildren, takeCurRoot); 
        
    }
}