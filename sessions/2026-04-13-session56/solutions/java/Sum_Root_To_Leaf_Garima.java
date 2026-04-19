/*
Problem Statement : https://leetcode.com/problems/sum-root-to-leaf-numbers/
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
    int res = 0;
    public int sumNumbers(TreeNode root) {
        getAllSum(root, 0);
        return res;
    }

    private void getAllSum(TreeNode root, int currSum) {
        if(root.left == null && root.right == null) {
            currSum = currSum * 10 + root.val;
            res += currSum;
            return;
        }

        if(root.left != null)
            getAllSum(root.left, currSum*10 + root.val);
        if(root.right != null)
           getAllSum(root.right, currSum*10 + root.val);
    }
}

/*
    Time Complexity : O(N) - Every node is visited only once
    Space Complexity : O(H), where H is the height of the tree
*/