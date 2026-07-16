/* 
	Problem link: 
	https://www.geeksforgeeks.org/problems/search-insert-position-of-k-in-a-sorted-array/1

	or

	https://leetcode.com/problems/search-insert-position/description/
*/

package main

func searchInsert(nums []int, target int) int {
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
    Time complexity : O(log n)
    Space complexity : O(1),
*/