/* 
	Problem Link: https://www.geeksforgeeks.org/problems/implement-upper-bound/1
*/
package main

func upperBound(nums []int, target int) int {
    left, right := 0, len(nums)

    for left < right {
        mid := left + (right-left) / 2

        if nums[mid] <= target {
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
