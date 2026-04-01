/**
 * @param {string} s
 * @return {string[][]}
 */

function isPalindrome(s) {
    let i = 0, j = s.length - 1;
    while (i < j) {
        if (s[i] === s[j]) {
            i++
            j--
        }
        else return false
    }
    return true
}
var partition = function (s) {
    let result = []
    function backtrack(path, remainingStr) {
        if (remainingStr.length === 0) result.push([...path])
        for (let i = 1; i <= remainingStr.length; i++) {
            let choice = remainingStr.substring(0, i)
            if (!isPalindrome(choice)) continue
            path.push(choice)
            backtrack(path, remainingStr.substring(i))
            path.pop()
        }
    }
    backtrack([], s)

    return result
};