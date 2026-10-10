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
    int counter = 0;
    int val = -1;  
    public int kthSmallest(TreeNode root, int k) {
         if(root == null)
            return -1; 
        serializeTree(root, k); 
        return val; 
    } 
    public void serializeTree(TreeNode root, int k) {
         if(root == null)
            return; 

        serializeTree(root.left, k);
        counter++; 
        if(counter == k)
            val = root.val;  
        serializeTree(root.right, k);
    }


}
