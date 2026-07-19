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
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
        for(int i=1;i<ans.size();i+=2){
            Collections.reverse(ans.get(i));
        }
        return ans;
     
    }
}