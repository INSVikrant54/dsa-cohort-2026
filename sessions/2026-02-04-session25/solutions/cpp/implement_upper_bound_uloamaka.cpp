/* 
    Problem Link: https://www.geeksforgeeks.org/problems/implement-upper-bound/1
*/
class Solution {
  public:
    int upperBound(vector<int>& arr, int target) {
        int left = 0;
        int right = arr.size();
        
        while(left < right){
            int mid = left + (right-left) / 2;

            if (arr[mid] <= target) 
            {
                left = mid+1;
            } 
            else 
            {
                right = mid;
            }
        }
        return left;
    }
};

/* 
    Time complexity : O(log n)
    Space complexity : O(1)
*/
