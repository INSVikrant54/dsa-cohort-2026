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
var minDepth = function (root) {
    function traverse(currNode) {
        if (!currNode) return 0
        let left = traverse(currNode.left)
        let right = traverse(currNode.right)

        if (left === 0) return 1 + right
        if (right === 0) return 1 + left
        return 1 + Math.min(left, right)
    }
    return traverse(root)
};