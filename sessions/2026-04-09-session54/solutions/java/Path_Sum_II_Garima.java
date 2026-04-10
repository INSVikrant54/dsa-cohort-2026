/*
Problem Statement : https://leetcode.com/problems/path-sum-ii/description/
*/

import java.util.List;
import java.util.ArrayList;

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
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        getPaths(root, 0, targetSum, new ArrayList<>());
        return res;
    }

    private void getPaths(TreeNode root, int sum, int target, List<Integer> currList) {
        if(root == null)
            return;
        
        currList.add(root.val);

        if(root.left == null && root.right == null) {
            if(root.val + sum == target) {
                res.add(new ArrayList<>(currList));
            }
            currList.remove(currList.size() - 1);
            return;
        }
        getPaths(root.left, sum + root.val, target, currList);
        getPaths(root.right, sum + root.val, target, currList);
        currList.remove(currList.size() - 1);
    }
}

/*
Approach : Bottom Up
Time Complexity : O(N^2); every node is visited once and copying the current list in res
Spae Complexity : O(H), where H is the height of the tree
 */
