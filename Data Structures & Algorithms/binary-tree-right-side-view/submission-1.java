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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){return new ArrayList<>();}
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr==null){
                if(!q.isEmpty()){
                    ans.add(new ArrayList<>());
                    q.add(null);
                }
            }
            else{
                ans.get(ans.size()-1).add(curr.val);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
        return ans;
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> ans = levelOrder(root);
        List<Integer> finalans =new ArrayList<>();
        for(List<Integer> li : ans){
            finalans.add(li.get(li.size()-1));
        }
        return finalans;
    }
}
