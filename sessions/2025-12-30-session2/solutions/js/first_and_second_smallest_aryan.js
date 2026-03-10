// https://www.geeksforgeeks.org/problems/find-the-smallest-and-second-smallest-element-in-an-array3226/1
class Solution {
    minAnd2ndMin(arr) {
        this.min = Infinity
        this.secondMin = Infinity

        for (let num of arr) {
            if (this.min > num) this.min = num
        }

        for (let num of arr) {
            if (this.secondMin > num && num !== this.min) this.secondMin = num
        }
        if (this.secondMin === Infinity) return [-1]
        return [this.min, this.secondMin]
    }
}