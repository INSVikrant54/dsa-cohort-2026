/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */

function reverseArr(left, right, arr) {
    while (left < right) {
        [arr[left], arr[right]] = [arr[right], arr[left]]
        left++
        right--
    }
}

var rotate = function (nums, k) {
    const n = nums.length;
    k = k % n

    reverseArr(0, n - 1, nums)
    reverseArr(0, k - 1, nums)
    reverseArr(k, n - 1, nums)

    return nums
};