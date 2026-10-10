public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }

        sb.append(root.val).append(",");

        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        int[] index = {0};

        return deserialize(strs, index);
    }

    private TreeNode deserialize(String[] strs, int[] index) {

        if (strs[index[0]].equals("#")) {
            index[0]++;
            return null;
        }

        TreeNode node = new TreeNode(
            Integer.parseInt(strs[index[0]])
        );

        index[0]++;

        node.left = deserialize(strs, index);
        node.right = deserialize(strs, index);

        return node;
    }
}