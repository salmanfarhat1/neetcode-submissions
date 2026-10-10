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
    boolean isSub = true; 
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null)
            return true;
        boolean left = false;
        boolean right = false; 

        if(root.left != null)
            left = isSubtree( root.left,  subRoot); 
        if(root.right != null)
            right = isSubtree( root.right,  subRoot); 
        return sameTree(root, subRoot) || left ||  right;
    }

    public boolean sameTree(TreeNode p, TreeNode q){
        if(p == null)
            return q == null;
        else if(q == null)
            return p == null; 
        else if(p == null && q == null)
            return true;
        return sameTree(p.left ,q.left) && sameTree(p.right , q.right) && q.val == p.val;  
    }
}
