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
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true; 
        boolean result = true; 
        if(root.left != null)
            result = root.left.val < root.val; 
        if(root.right != null) 
           result = result && root.right.val > root.val; 
        return result && isValidBST(root.left) && isValidBST(root.right);
    }
}
