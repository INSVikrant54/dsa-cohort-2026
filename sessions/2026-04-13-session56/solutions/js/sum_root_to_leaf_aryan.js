// https://leetcode.com/problems/sum-root-to-leaf-numbers/
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var sumNumbers = function (root) {
    let sum = 0;

    function traverse(curr, pathStr) {
        if (!curr) return

        const isLeafNode = !curr.right && !curr.left
        const updatedPathStr = pathStr + curr.val

        if (isLeafNode) {
            sum += +updatedPathStr
        }
        traverse(curr.left, updatedPathStr)
        traverse(curr.right, updatedPathStr)
    }

    traverse(root, "")

    return sum
};