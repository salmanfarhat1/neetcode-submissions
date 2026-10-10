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
    TreeNode ans= null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = root; 
        lowestCommonAncestorHelper(root, p ,q); 
        return ans; 
    }
    public void lowestCommonAncestorHelper(TreeNode root, TreeNode p , TreeNode q){
        if(root == null)
            return;
        if(searchSubTreeContainsPQ(root, p ,q ))
            ans = root; 
        lowestCommonAncestorHelper(root.left, p ,q); 
        lowestCommonAncestorHelper(root.right, p ,q); 
    } 
    public boolean searchSubTreeContainsPQ(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)    
            return false; 
        
        return searchSubTree(root , p) && searchSubTree(root,  q); 
    } 

    public boolean searchSubTree(TreeNode root, TreeNode p){
        if(root == null)    
            return false; 
        
        return searchSubTree(root.left, p) || searchSubTree(root.right, p) || root == p; 
    } 
}
