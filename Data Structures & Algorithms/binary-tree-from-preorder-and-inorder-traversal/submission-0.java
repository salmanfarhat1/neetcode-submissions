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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>(); 
        int n = inorder.length;
        for(int i = 0; i < n; i++)
            map.put(inorder[i], i);
        
        int curIndex = map.get(preorder[0]);
        return buildTreeHelper(inorder,  curIndex , 0, n - 1);
    }
    public TreeNode buildTreeHelper(int[] inorder, int curIndex, int left , int right){
        if(left == right)
            return new TreeNode(inorder[left]); 
        if(left > right)
            return null;
        TreeNode node = new TreeNode(inorder[curIndex]);
        node.left = buildTreeHelper(inorder, curIndex - 1 , left , curIndex -1);
        node.right = buildTreeHelper(inorder, curIndex + 1, curIndex + 1 , right); 
        return node;  
    } 
}
