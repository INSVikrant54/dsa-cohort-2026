// https://www.geeksforgeeks.org/problems/second-largest3735/1

class Solution {
    getSecondLargest(arr) {
        this.firstLarge = -1
        this.secondLarge = -1

        for (let num of arr) {
            if (num > this.firstLarge) this.firstLarge = num
        }

        for (let num of arr) {
            if (num > this.secondLarge && this.firstLarge !== num) this.secondLarge = num
        }
        return this.secondLarge
    }
}