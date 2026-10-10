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
        
        int curIndex = 0, left = 0, right = n -1; 
        return buildTreeHelper(preorder,  curIndex , left, right, map);
    }
    public TreeNode buildTreeHelper(int[] preorder, int curIndex, int left , 
                                        int right, HashMap<Integer, Integer> map){
        if(left > right)
            return null;
        
        int rootVal = preorder[curIndex]; 
        int rootValIndexInOrder = map.get(rootVal);

        int leftRootIndex  = curIndex + 1; 
        int rightRootIndex  = curIndex + (rootValIndexInOrder - left) +1; 
         
        
        TreeNode node = new TreeNode(rootVal);

        node.left = buildTreeHelper(preorder, leftRootIndex , left ,rootValIndexInOrder - 1  , map);
        node.right = buildTreeHelper(preorder, rightRootIndex, rootValIndexInOrder + 1 , right, map); 
        return node;  
    } 
}
