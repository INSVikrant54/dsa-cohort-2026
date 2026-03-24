/**
 * @param {number[]} arr
 * @param {number} l
 * @param {number} r
 */
class Solution {
    merge(arr, l, m, r) {
        let n1 = m - l + 1
        let n2 = r - m
        let L = new Array(n1)
        let R = new Array(n2)

        let k = l

        for (let i = 0; i < n1; i++) {
            L[i] = arr[k++]
        }

        for (let j = 0; j < n2; j++) {
            R[j] = arr[k++]
        }

        let i = 0, j = 0;
        k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++]
            else arr[k++] = R[j++]
        }

        while (i < n1) {
            arr[k++] = L[i++]
        }

        while (j < n2) {
            arr[k++] = R[j++]
        }

    }

    mergeSort(arr, l, r) {
        if (l >= r) return
        let m = Math.floor(l + (r - l) / 2)

        this.mergeSort(arr, l, m)
        this.mergeSort(arr, m + 1, r)
        this.merge(arr, l, m, r)
    }
}