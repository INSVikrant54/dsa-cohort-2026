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
 * @return {string[]}
 */
var binaryTreePaths = function (root) {
    let result = []

    function traverse(curr, path) {
        if (!curr) return

        let newPath = path === '' ? "" + `${curr.val}` : path + '->' + curr.val
        const isLeafNode = !curr.left && !curr.right

        if (isLeafNode) result.push(newPath)

        traverse(curr.left, newPath)
        traverse(curr.right, newPath)
    }

    traverse(root, '')

    return result
};