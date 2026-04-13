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
        
        if(!isLeaf(root)) {
            res.add(root.val);
        }

        addLeftBoundaryNodes(root, res);
        addLeaves(root, res);
        addRightBoundaryNodes(root, res);
        return res;
    }

    private void addLeftBoundaryNodes(TreeNode root, List<Integer> res) {
        TreeNode temp = root.left;
        while(temp != null) {
            if(!isLeaf(temp)) {
                res.add(temp.val);
            }
            if(temp.left != null) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
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
        TreeNode temp = root.right;
        List<Integer> list = new ArrayList<>();
        while(temp != null) {
            if(!isLeaf(temp)) {
                list.add(temp.val);
            }
            if(temp.right != null) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }
        Collections.reverse(list);
        for(int i : list) {
            res.add(i);
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