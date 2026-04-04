class Solution
{
private:
    int isPossible(vector<vector<bool>> &maze, int row, int col)
    {
        // Horizontall check
        for (int i = 0; i < col; i++)
        {
            if (maze[row][i])
                return false;
        }

        // Top vertically check
        int top = min(row, col);
        for (int i = 1; i <= top; i++)
        {
            if (maze[row - i][col - i])
                return false;
        }

        // bottom verticall check
        int bottom = min((int)maze.size() - row - 1, col);
        for (int i = 1; i <= bottom; i++)
        {
            if (maze[row + i][col - i])
                return false;
        }
        return true;
    }
    void helper(vector<vector<bool>> &maze, vector<vector<string>> &ans, vector<string> &ds, int col, int n)
    {
        if (col >= maze[0].size())
        {
            // reverse(ds.begin(), ds.end());
            ans.push_back(ds);
            return;
        }

        string s;
        for (int i = 0; i < n; i++)
        {
            s.push_back('.');
        }

        for (int row = 0; row < maze.size(); row++)
        {
            if (isPossible(maze, row, col))
            {
                maze[row][col] = true;
                s[row] = 'Q';
                ds.push_back(s);
                helper(maze, ans, ds, col + 1, n);
                maze[row][col] = false;
                s[row] = '.';
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