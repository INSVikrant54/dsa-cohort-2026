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
 * @param {number} targetSum
 * @return {boolean}
 */
var hasPathSum = function (root, targetSum) {
    if (!root) return false
    function traverse(curr, sum) {
        sum = sum + curr.val
        if (!curr.left && !curr.right) return sum === targetSum
        let left = curr?.left ? traverse(curr.left, sum) : false
        let right = curr?.right ? traverse(curr.right, sum) : false
        return left || right
    }
    return traverse(root, 0)
};