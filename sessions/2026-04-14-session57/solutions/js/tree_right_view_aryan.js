// https://leetcode.com/problems/binary-tree-right-side-view/

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
var rightSideView = function (root) {
    if (!root) return []
    let q = [root]
    const result = []

    while (q.length) {
        let qLen = q.length;
        for (let i = 0; i < qLen; i++) {
            let curr = q.shift()
            if (i === qLen - 1) result.push(curr.val)
            curr.left && q.push(curr.left)
            curr.right && q.push(curr.right)
        }
    }
    return result
};