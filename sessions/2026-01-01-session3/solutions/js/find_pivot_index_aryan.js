/**
 * @param {number[]} nums
 * @return {number}
 */
var pivotIndex = function (nums) {
    const sum = nums.reduce((acc, curr) => acc + curr, 0)
    let leftSum = 0

    for (let i = 0; i < nums.length; i++) {
        let rightSum = sum - leftSum - nums[i]
        if (leftSum === rightSum) return i
        leftSum += nums[i]
    }
    return -1
};