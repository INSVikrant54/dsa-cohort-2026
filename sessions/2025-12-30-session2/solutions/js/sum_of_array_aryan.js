// https://www.geeksforgeeks.org/problems/sum-of-array2326/1
/**
 * @param {number[]} arr - The array of numbers to sum
 * @return {number} - The sum of the array elements
 */
class Solution {
    arraySum(arr) {
        let sum = 0;
        for(let num of arr) sum += num
        return sum
    }
}