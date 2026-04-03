/**
 * @param {number[]} nums
 * @return {number}
 */
var findMaxConsecutiveOnes = function (arr) {
    let maxOnesCount = 0, maxTillNow = 0

    for (let i = 0; i < arr.length; i++) {
        if (0 === arr[i]) maxOnesCount = 0
        else {
            maxOnesCount++
            if (maxTillNow < maxOnesCount) maxTillNow = maxOnesCount
        }
    }
    return maxTillNow
};