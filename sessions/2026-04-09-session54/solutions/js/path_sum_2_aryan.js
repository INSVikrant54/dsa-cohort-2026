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
 * @return {number[][]}
 */
var pathSum = function (root, targetSum) {
    let result = []

    function traverse(curr, sum, arr) {
        if (!curr) return
        arr.push(curr.val)
        sum += curr.val

        const isLeaf = !curr.left && !curr.right
        if (isLeaf) {
            if (sum === targetSum) result.push([...arr])
            return
        }

        traverse(curr.left, sum, [...arr])
        traverse(curr.right, sum, [...arr])
    }

    traverse(root, 0, [])
    return result
};

// improved version with backtracking

var pathSum = function (root, targetSum) {
    let result = []

    function traverse(curr, sum, arr) {
        if (!curr) return
        arr.push(curr.val)
        sum += curr.val

        const isLeaf = !curr.left && !curr.right
        if (isLeaf && sum === targetSum) result.push([...arr])
        traverse(curr.left, sum, arr)
        traverse(curr.right, sum, arr)
        arr.pop()
    }

    traverse(root, 0, [])
    return result
};