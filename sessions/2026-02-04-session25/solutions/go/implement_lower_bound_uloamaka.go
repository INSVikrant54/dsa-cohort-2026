/* 
    Problem Link: https://www.geeksforgeeks.org/problems/implement-lower-bound/1

	similar 

	Problem Link: https://leetcode.com/problems/search-insert-position/description/
*/

package main

func lowerBounds(nums []int, target int) int {
    left, right := 0, len(nums)

    for left < right {
        mid := left + (right - left) / 2

        if nums[mid] < target {
            left = mid + 1
        } else {
            right = mid
        }
    }
    return left
}

/*
    Time complexity: O(log n)
    Space complexity: O(1)
*/
