/**
 * @param {number} k
 * @param {number} n
 * @return {number[][]}
 */
var combinationSum3 = function (k, n) {
    let result = []

    function backtrack(remainingSum, path, start) {
        if (remainingSum === 0 && path.length === k) result.push([...path])
        if (path.length === k) return

        for (let i = start; i <= 9; i++) {
            path.push(i)
            backtrack(remainingSum - i, path, i + 1)
            path.pop()
        }
    }
    backtrack(n, [], 1)

    return result;
};