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
    int global = Integer.MIN_VALUE;
    int findmax(TreeNode root){
        if(root==null) return 0;
        int left = Math.max(0,findmax(root.left));
        int right = Math.max(0,findmax(root.right));
        int curr = root.val + left + right;
        global = Math.max(global,curr);
        return root.val + Math.max(left,right);
    }
    public int maxPathSum(TreeNode root) {
        findmax(root);
        return global;
    }
}
