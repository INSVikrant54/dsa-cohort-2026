/**
 * @param {number[]} arr
 * @returns {void}
 */

class Solution {
    reverseArray(arr) {
        let i = 0, j = arr.length - 1;
        while(i < j){
            [arr[j], arr[i]] = [arr[i], arr[j]]
            i++
            j--
        }
        return arr
    }
}