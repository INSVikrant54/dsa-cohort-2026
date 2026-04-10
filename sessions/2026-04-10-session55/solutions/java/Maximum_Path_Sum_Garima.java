/*
Problem Statement : https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
*/


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
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMaxPathSum(root);
        return res;
    }

    private int getMaxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        
        int leftPathSum = Math.max(0, getMaxPathSum(root.left));
        int rightPathSum = Math.max(0, getMaxPathSum(root.right));
        res = Math.max(res, root.val + leftPathSum + rightPathSum);
        return root.val + Math.max(leftPathSum, rightPathSum);
    }
}

/*
Approach : Bottom Up
Time Complexity : O(N) - Every node is visited only once
Spae Complexity : O(H), where H is the height of the tree
 */