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

// top down approach
var maxDepth = function (root) {
    let maximumDepth = 0;

    function traverse(currNode, depth) {
        if (!currNode) return currNode
        maximumDepth = Math.max(depth, maximumDepth)
        traverse(currNode.left, depth + 1)
        traverse(currNode.right, depth + 1)
    }

    traverse(root, 1)

    return maximumDepth

};

// bottom up approach

var maxDepth = function (root) {
    function traverse(currNode) {
        if (!currNode) return 0
        let left = traverse(currNode.left)
        let right = traverse(currNode.right)
        return 1 + Math.max(left, right)
    }
    return traverse(root)
};