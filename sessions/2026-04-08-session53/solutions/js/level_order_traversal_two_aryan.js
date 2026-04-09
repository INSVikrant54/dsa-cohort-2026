// Input --> [3,9,20,null,null,15,7]
// Ouptut --> [3, 9, 20, 15, 7]
// https://www.naukri.com/code360/problems/level-order-traversal_796002

var levelOrder = function (root) {
    if (!root) return []

    let q = [root]
    let result = []

    while (q.length) {
        let curr = q.shift()
        result.push(curr.val)

        if (curr.left) q.push(curr.left)
        if (curr.right) q.push(curr.right)
    }

    return result
};