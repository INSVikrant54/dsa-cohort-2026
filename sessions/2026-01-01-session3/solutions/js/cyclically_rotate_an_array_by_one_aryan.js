class Solution {

    reverse(left, right, arr) {
        while (left < right) {
            [arr[right], arr[left]] = [arr[left], arr[right]]
            left++
            right--
        }
    }

    rotate(arr) {
        const n = arr.length
        this.reverse(0, n - 1, arr)
        this.reverse(1, n - 1, arr)
        return arr
    }
}