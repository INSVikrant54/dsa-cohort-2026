// https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
/**
 * @param {Node} root
 * @returns {number[]}
 */

/*
class Node{
    constructor(data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    boundaryTraversal(root) {
        if (!root) return []

        let result = []

        function isLeaf(node) {
            return !node.left && !node.right
        }

        function addLeftBoundary(node) {
            let curr = node.left
            while (curr) {
                if (!isLeaf(curr)) result.push(curr.data)
                curr = curr.left ? curr.left : curr.right
            }
        }

        function addLeaves(node) {
            if (!node) return

            if (isLeaf(node)) result.push(node.data)

            addLeaves(node.left)
            addLeaves(node.right)
        }

        function addRightBoundary(node) {
            let curr = node.right
            let temp = []
            while (curr) {
                if (!isLeaf(curr)) temp.push(curr.data)
                curr = curr.right ? curr.right : curr.left
            }
            for (let i = temp.length - 1; i >= 0; i--) {
                result.push(temp[i]);
            }
        }

        if (!isLeaf(root)) result.push(root.data)

        addLeftBoundary(root)
        addLeaves(root)
        addRightBoundary(root)

        return result

    }
}