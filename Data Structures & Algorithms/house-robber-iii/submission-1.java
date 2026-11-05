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
    HashMap<TreeNode, Integer> memo = new HashMap<>(); 
    public int rob(TreeNode root) {
        
        if(root == null)
            return 0; 
        if(root.left == null && root.right == null)
            return root.val; 
        if(memo.containsKey(root))
            return memo.get(root);
        
        int takeChildren = rob(root.left) + rob(root.right); 

        int takeCurRoot = root.val; 
       if(root.left != null)
            takeCurRoot += rob(root.left.left) + rob(root.left.right);

        if(root.right != null)
            takeCurRoot += rob(root.right.right) + rob(root.right.left);

        memo.put(root, Math.max(takeChildren, takeCurRoot)); 
        return memo.get(root);
        
    }
}