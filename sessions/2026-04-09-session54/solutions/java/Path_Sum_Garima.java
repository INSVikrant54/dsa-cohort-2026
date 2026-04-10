/*
Problem Statement : https://leetcode.com/problems/path-sum/description/
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasTarget(root, 0, targetSum);
    }

    private boolean hasTarget(TreeNode root, int sum, int targetSum) {
        if(root == null)
            return false;

        if(root.left == null && root.right == null) {
            if(sum + root.val == targetSum)
                return true;
            return false;
        }

        return hasTarget(root.left, sum + root.val, targetSum) || hasTarget(root.right, sum + root.val, targetSum);
    }
}

/*
Approach : Bottom Up
Time Complexity : O(N) - Every node is visited only once
Spae Complexity : O(H), where H is the height of the tree
 */