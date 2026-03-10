/**
 * @param {number[]} arr
 * @returns {number[]}
 */

class Solution {
    constructor() {
        this.max = -Infinity;
        this.min = Infinity;
    }
    getMinMax(arr) {
        for (const element of arr) {
            if (element > this.max) this.max = element
            if (element < this.min) this.min = element
        }
        return [this.min, this.max]
    }
}