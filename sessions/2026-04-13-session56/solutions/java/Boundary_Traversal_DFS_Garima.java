/*
Problem Link: https://leetcode.com/problems/boundary-of-binary-tree/description/
*/

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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        List<Integer> rightBoundaryNodesList = new ArrayList<>();
        
        if(!isLeaf(root)) {
            res.add(root.val);
        }

        if(root.left != null) 
            addLeftBoundaryNodes(root.left, res);

        addLeaves(root, res);

        if(root.right != null) 
            addRightBoundaryNodes(root.right, res);
            
        return res;
    }

    private void addLeftBoundaryNodes(TreeNode root, List<Integer> res) {
        if(root == null)
            return;

        if(!isLeaf(root)) {
            res.add(root.val);
        }

        if(root.left != null) {
            addLeftBoundaryNodes(root.left, res);
        } else {
            addLeftBoundaryNodes(root.right, res);
        }
    }

    private void addLeaves(TreeNode root, List<Integer> res) {
        if(root == null)
            return;

        if(isLeaf(root)) {
            res.add(root.val);
        }

        addLeaves(root.left, res);
        addLeaves(root.right, res);
    }

    private void addRightBoundaryNodes(TreeNode root, List<Integer> res) {
        if(root == null)
            return;

        if(root.right != null) {
            addRightBoundaryNodes(root.right, res);
        } else {
            addRightBoundaryNodes(root.left, res);
        }

        if(!isLeaf(root)) {
            res.add(root.val);
        }
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}

/*
    Time Complexity : O(N) - Every node is visited only once
    Space Complexity : O(H), where H is the height of the tree
*/