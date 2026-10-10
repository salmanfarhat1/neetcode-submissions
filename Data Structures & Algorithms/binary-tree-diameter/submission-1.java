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
    int max = 0; 
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0; 
        getLongestPath(root); 
        return max; 
    }
    public int getLongestPath(TreeNode root){
        if(root == null)
            return 0;

        int left = getLongestPath(root.left);
        int right = getLongestPath(root.right);

        if(left + right > max)
            max = left + right; 
        
        return 1 + Math.max(left, right);
    } 
}
