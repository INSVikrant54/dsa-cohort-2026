// https://leetcode.com/problems/combination-sum/

/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function (candidates, target) {
    let result = []

    function backtrack(remainingSum, path, start) {
        if (remainingSum === 0) result.push([...path])
        if (remainingSum <= 0) return

        for (let i = start; i < candidates.length; i++) {
            path.push(candidates[i])
            backtrack(remainingSum - candidates[i], path, i)
            path.pop()
        }
    }
    backtrack(target, [], 0)

    return result;
};