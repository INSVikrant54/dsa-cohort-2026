// https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1
/**
 * @param {Node} root
 * @returns {number[]}
 */

/*
class Node {
    constructor(data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    leftView(root) {
        if (!root) return []
        let q = [root]
        const result = []

        while (q.length) {
            let qLen = q.length;
            for (let i = 0; i < qLen; i++) {
                let curr = q.shift()
                if (i === 0) result.push(curr.data)
                curr.left && q.push(curr.left)
                curr.right && q.push(curr.right)
            }
        }
        return result

    }
}