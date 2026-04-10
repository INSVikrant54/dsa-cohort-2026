/*
Problem Statement : https://leetcode.com/problems/binary-tree-paths/
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();
        findPaths(root, res, currPath);
        return res;
    }

    private void findPaths(TreeNode root, List<String> res, List<Integer> currPath) {
        if(root == null)
            return;

        currPath.add(root.val);

        if(root.left == null && root.right == null) {
            StringBuilder currPathStr = new StringBuilder();

            for(int x : currPath) {
                currPathStr.append(String.valueOf(x));
                currPathStr.append("->");
            }
            String st = currPathStr.toString();
            st = st.substring(0, st.length() - 2);
            res.add(st);

            currPath.remove(currPath.size() - 1);
            return;
        }

        findPaths(root.left, res, currPath);
        findPaths(root.right, res, currPath);
        currPath.remove(currPath.size() - 1);
    }
}

/*
Approach : Bottom Up
Time Complexity : O(N^2)
Spae Complexity : O(H), where H is the height of the tree
 */