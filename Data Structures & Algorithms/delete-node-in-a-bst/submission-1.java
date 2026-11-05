class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode nodeToDelete = findNode(root, key);

        if(nodeToDelete == null)
            return root;

        if(nodeToDelete.left == null)
            return replaceNodeInParent(root, nodeToDelete, nodeToDelete.right);

        // Case 2: No right child
        if(nodeToDelete.right == null)
            return replaceNodeInParent(root, nodeToDelete, nodeToDelete.left);

        // Case 3: Two children
        TreeNode predecessor = nodeToDelete.left;
        TreeNode predecessorParent = null;

        while(predecessor.right != null) {
            predecessorParent = predecessor;
            predecessor = predecessor.right;
        }

        nodeToDelete.val = predecessor.val;

        if(predecessorParent == null)
            nodeToDelete.left = predecessor.left;
        else
            predecessorParent.right = predecessor.left;

        return root;
    }

    public TreeNode replaceNodeInParent(TreeNode root, TreeNode node, TreeNode replacement) {
        if(root == node)
            return replacement;

        TreeNode parent = findParent(root, node);

        if(parent.left == node)
            parent.left = replacement;
        else
            parent.right = replacement;

        return root;
    }

    public TreeNode findParent(TreeNode root, TreeNode node) {
        if(root == null)
            return null;

        if(root.left == node || root.right == node)
            return root;

        if(node.val < root.val)
            return findParent(root.left, node);

        return findParent(root.right, node);
    }

    public TreeNode findNode(TreeNode root, int key) {
        if(root == null)
            return null;

        if(root.val == key)
            return root;

        if(key < root.val)
            return findNode(root.left, key);

        return findNode(root.right, key);
    }
}