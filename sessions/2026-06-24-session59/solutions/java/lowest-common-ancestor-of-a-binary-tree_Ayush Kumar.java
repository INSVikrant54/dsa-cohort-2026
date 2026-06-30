/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        
        return lca(root, p, q);
    }

    public TreeNode lca(TreeNode root, TreeNode left, TreeNode right)
    {
        if(root == null)
        return null;

        if(root == left || root == right)
        return root;

        TreeNode l = lca(root.left, left, right);
        TreeNode r = lca(root.right, left, right);

        if(l!=null && r!=null)
        return root;
        else if(l!= null && r==null)
        return l;
        else if(r!=null && l==null)
        return r;

        return null;
    }
}