/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
   Node findpar(Node p){
    Node curr = p;
    while(curr.parent!=null){
        curr =curr.parent;
    }
    return curr;
   }
   Node ans(Node root,Node p,Node q){
    if(root==p || root==q) return root;
    if(root==null) return null;
    Node left = ans(root.left,p,q);
    Node right = ans(root.right,p,q);
    if(left!=null && right!=null) return root;
    else if(left!=null) return left;
    else if(right!=null) return right;
    else return null;
   }
    public Node lowestCommonAncestor(Node p, Node q) {
        Node root = findpar(p);
        Node answer = ans(root,p,q);
        return answer;
    }
}