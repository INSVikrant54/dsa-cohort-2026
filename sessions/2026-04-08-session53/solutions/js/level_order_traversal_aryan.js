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
 * @return {number[][]}
 */
var levelOrder = function (root) {
    if (!root) return []
    let q = [root]
    let result = []
    while (q.length) {

        const level = []
        const levelSize = q.length;

        for (let i = 0; i < levelSize; i++) {
            let lastItem = q.shift()
            level.push(lastItem.val)
            lastItem.left && q.push(lastItem.left)
            lastItem.right && q.push(lastItem.right)
        }

        result.push(level)
    }

    return result
};