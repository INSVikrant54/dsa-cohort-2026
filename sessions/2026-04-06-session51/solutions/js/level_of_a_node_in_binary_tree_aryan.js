/**
 * @param {Node} root
 * @param {number} target
 * @return {number}
 */
class Solution {
    getLevel(root, target) {
        let result = 0
        function traverse(curr, level) {
            if (!curr) return

            if (curr.data === target) result = level

            traverse(curr.left, level + 1)
            traverse(curr.right, level + 1)
        }
        traverse(root, 1)

        return result
    }
}

// optimized
// As soon as target is found immediately return level

class Solution {
    getLevel(root, target) {
        function traverse(curr, level) {
            if (!curr) return 0

            if (curr.data === target) return level

            const left = traverse(curr.left, level + 1)

            if (left) return left

            return traverse(curr.right, level + 1)
        }
        return traverse(root, 1)
    }
}