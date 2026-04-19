/*
Problem Link: https://leetcode.com/problems/binary-tree-right-side-view/description/
*/

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        
        // Preorder traversal - root, left, right
        getRightSideViewNodes(root, 0, res);

        // Preorder traversal - root, right, left
        getRightSideViewNodesRightLeft(root, 0, res);
        return res;
    }

    private void getRightSideViewNodes(TreeNode root, int currLevel, List<Integer> res) {
        if(root == null)
            return;

        if(res.size() == currLevel) {
            res.add(root.val);
        } else {
            res.set(currLevel, root.val);
        }
        
        getRightSideViewNodes(root.left, currLevel + 1, res);
        getRightSideViewNodes(root.right, currLevel + 1, res);
    }

    private void getRightSideViewNodesRightLeft(TreeNode root, int currLevel, List<Integer> res) {
        if(root == null)
            return;

        if(res.size() == currLevel) {
            res.add(root.val);
        }
        
        getRightSideViewNodesRightLeft(root.right, currLevel + 1, res);
        getRightSideViewNodesRightLeft(root.left, currLevel + 1, res);
    }
}

/*
    Time Complexity : O(N) - Every node is visited only once
    Space Complexity : O(H), where H is the height of the tree
*/