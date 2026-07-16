/* 
	Problem link: https://leetcode.com/problems/binary-search/description/
*/

package main

func search(nums []int, target int) int {
    left, right := 0, len(nums)

    for left < right {
        mid := left + (right-left) / 2

        if nums[mid] == target {
            return mid
        } else if nums[mid] < target {
            left = mid + 1
        } else {
            right = mid
        }
    }

    return -1  
}

/*
    Time complexity: O(log n)
    Space complexity: O(1)
*/
