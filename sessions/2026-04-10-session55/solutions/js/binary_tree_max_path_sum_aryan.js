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
var maxPathSum = function (root) {
    let maxSum = -Infinity

    function traverse(curr) {
        if (!curr) return 0
        const left = traverse(curr.left)
        const right = traverse(curr.right)

        const pathThroughNode = left + right + curr.val
        const oneSidePath = Math.max(left, right) + curr.val
        const currNodeOnly = curr.val

        maxSum = Math.max(maxSum, pathThroughNode, oneSidePath, currNodeOnly)

        return Math.max(oneSidePath, currNodeOnly)
    }
    traverse(root)

    return maxSum
};