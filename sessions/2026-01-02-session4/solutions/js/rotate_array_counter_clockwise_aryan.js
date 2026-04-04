/**
 * @param {number[]} arr
 * @param {number} d
 */

class Solution {
    reverse(left, right, arr){
        while(left < right){
            [arr[left], arr[right]] = [arr[right], arr[left]]
            left++
            right--
        }
    }
    
    rotateArr(arr, d) {
        const n = arr.length
        d = d % n
        this.reverse(0, n - 1, arr)
        this.reverse(0, n - d - 1, arr)
        this.reverse(n - d, n - 1, arr)
        return arr
    }
}