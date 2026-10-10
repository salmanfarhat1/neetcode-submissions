/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    boolean isBalanced = true; 
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true; 
        getHeight(root);
        return isBalanced;
    }
    public int getHeight(TreeNode root){
        if(root == null)
            return 0; 
        
        int left = getHeight(root.left ); 
        int right = getHeight(root.right); 

        if(Math.abs(left - right) > 1)
            isBalanced = false; 
        return 1 + Math.max(left,  right);
    } 
}
