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
 * @return {number[]}
 */
var inorderTraversal = function (root) {
    let result = []

    function traverse(currNode) {
        if (!currNode) return
        traverse(currNode.left)
        result.push(currNode.val)
        traverse(currNode.right)
    }

    traverse(root)
    return result
};