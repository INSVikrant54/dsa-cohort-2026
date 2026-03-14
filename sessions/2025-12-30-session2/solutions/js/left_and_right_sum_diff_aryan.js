/**
 * @param {number[]} nums
 * @return {number[]}
 */

// Time: O(n) 
// Space: O(n) 
var leftRightDifference = function (nums) {
    let arr = new Array(nums.length).fill(0)
    let arr2 = [...arr]
    let result = [...arr]

    for (let i = 1; i < arr.length; i++) {
        arr[i] = arr[i - 1] + nums[i - 1]
    }

    for (let i = arr2.length - 2; i >= 0; i--) {
        arr2[i] = arr2[i + 1] + nums[i + 1]
    }
    for (let i = 0; i < result.length; i++) {
        result[i] = Math.abs(arr[i] - arr2[i])
    }
    return result
};

// optimized
// Time: O(n)
// Space: O(1) 

var leftRightDifference = function (arr) {
    let result = new Array(arr.length).fill(0)

    let leftSum = 0;
    for (let i = 0; i < arr.length; i++) {
        result[i] += leftSum
        leftSum += arr[i]
    }

    let rightSum = 0;
    for (let i = arr.length - 1; i >= 0; i--) {
        result[i] = Math.abs(result[i] - rightSum)
        rightSum += arr[i]
    }

    return result
};