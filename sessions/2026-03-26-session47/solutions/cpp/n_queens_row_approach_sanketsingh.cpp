// This is the row by row approach to solve n queens problem where we traverse through each row.
class Solution
{
private:
    bool isPossible(vector<vector<bool>> &maze, int row, int col)
    {
        // checking vertically
        for (int i = 0; i < row; i++)
        {
            if (maze[i][col])
                return false;
        }

        // checking left horizontally
        int maxleft = min(row, col);
        for (int i = 1; i <= maxleft; i++)
        {
            if (maze[row - i][col - i])
                return false;
        }

        // checking right horizontally
        int maxRight = min(row, (int)maze.size() - col - 1);
        for (int i = 1; i <= maxRight; i++)
        {
            if (maze[row - i][col + i])
                return false;
        }
        return true;
    }

    void helper(vector<vector<bool>> &maze, vector<vector<string>> &ans, vector<string> &ds, int row, int n)
    {
        if (row >= maze.size())
        {
            ans.push_back(ds);
            return;
        }

        string s;
        for (int i = 0; i < n; i++)
        {
            s.push_back('.');
        }

        for (int col = 0; col < maze.size(); col++)
        {
            if (isPossible(maze, row, col))
            {
                maze[row][col] = true;
                s[col] = 'Q';
                ds.push_back(s);
                helper(maze, ans, ds, row + 1, n);
                maze[row][col] = false;
                s[col] = '.';
                ds.pop_back();
            }
        }
    }

public:
    vector<vector<string>> solveNQueens(int n)
    {
        vector<string> ds;
        vector<vector<string>> ans;
        vector<vector<bool>> maze(n, vector<bool>(n, false));
        helper(maze, ans, ds, 0, n);
        return ans;
    }
};