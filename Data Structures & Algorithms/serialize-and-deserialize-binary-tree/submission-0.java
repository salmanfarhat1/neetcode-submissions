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

public class Codec {
    List<Integer> preOrderList = new ArrayList<>(); 
    List<Integer> inOrderList = new ArrayList<>(); 
    public String serialize(TreeNode root) {
        String s = ""; 
        if(root == null)
            return s;
        preOrder(root);
        inOrder(root);
        s = listToString(preOrderList) + "|" + listToString(inOrderList);
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(""))
            return null; 

        String[] strs = data.split("\\|"); 
      
      
        inOrderList= stringToList(strs[0]);
        preOrderList = stringToList(strs[1] ); 



        HashMap<Integer, Integer> map = new HashMap<>();
        // 2,1,4,3,5|1,2,3,4,5
        // Inorder  | preOrder
        for(int i = 0; i < inOrderList.size(); i++){

            map.put(inOrderList.get(i), i);
        }
        return constructBTree(preOrderList, 0, 0, preOrderList.size() -1 , map);
        
    }
    public TreeNode constructBTree(List<Integer> preOrderList, int curIndex,
                                                int left, int right, HashMap<Integer, Integer> map){
            if(preOrderList.size() == 0)
                return null; 
            if( left > right)
                return null;
            
            int rootVal = preOrderList.get(curIndex); 
            int rootValIndex = map.get(rootVal);

            
            int leftRootIndex = curIndex + 1; 
            int rightRootIndex = curIndex +  ( rootValIndex - left + 1); 

            TreeNode node = new TreeNode(rootVal); 
            node.left = constructBTree(preOrderList, leftRootIndex, left,rootValIndex -1, map );
            node.right = constructBTree(preOrderList, rightRootIndex, rootValIndex + 1, right, map );
            return node; 
        }
    public List<Integer> stringToList(String s){
        String[] strs = s.split(",");
        List<Integer> list = new ArrayList<>(); 

        for(int i =0; i < strs.length; i++){
            list.add(Integer.parseInt(strs[i]));
        }
        return list;
    }
    public void preOrder(TreeNode root){
        if(root == null)
            return; 
        preOrder(root.left);
        preOrderList.add(root.val);
        preOrder(root.right);  
    }
    public void inOrder(TreeNode root){
        if(root == null)
            return; 
        inOrderList.add(root.val);
        inOrder(root.left);
        inOrder(root.right);  
    }
    public String listToString(List<Integer> list){
        String s = "";
        for(int i =0; i < list.size(); i++){
            s = (i == list.size() - 1) ?  s + list.get(i) : s + list.get(i) + ","; 
        }
        return s;
    } 
}
