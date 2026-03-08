class Solution
{
private:
    void helper(vector<int> &nums, vector<vector<int>> &ans, vector<int> currSubset, int index)
    {
        if (index >= nums.size())
        {
            ans.push_back(currSubset);
            return;
        }

        currSubset.push_back(nums[index]);
        helper(nums, ans, currSubset, index + 1);
        currSubset.pop_back();
        while (index < nums.size() - 1 && nums[index] == nums[index + 1])
        {
            index++;
        }
        helper(nums, ans, currSubset, index + 1);
    }

public:
    vector<vector<int>> subsetsWithDup(vector<int> &nums)
    {
        sort(nums.begin(), nums.end());
        vector<vector<int>> ans;
        helper(nums, ans, {}, 0);
        return ans;
    }
};