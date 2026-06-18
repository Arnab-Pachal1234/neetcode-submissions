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

    // Encodes a tree to a single string.
    String inorder(TreeNode root){
        if(root==null) return "#";
        String left = inorder(root.left);
        String right = inorder(root.right);
        String curr = String.valueOf(root.val)+","+left+","+right;
        return  curr;
    }
    public String serialize(TreeNode root) {
       String ans = inorder(root);
       return ans;
    }

     int i=0;
     public TreeNode build(String s[]) {
       if (s[i].equals("#") ){
        i++;
        return null;
       }
       TreeNode root = new TreeNode(Integer.valueOf(s[i++]));
       root.left = build(s);
       root.right = build(s);
       return root;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        i=0;
        TreeNode root = build(data.split(","));
        return root;
    }
}
