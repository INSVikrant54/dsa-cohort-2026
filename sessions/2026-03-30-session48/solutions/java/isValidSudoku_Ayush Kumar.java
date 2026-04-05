class Solution {
    public boolean isValidSudoku(char[][] board) 
    {
        
        for(int row=0;row<9;row++)
        {
            for(int column=0;column<9;column++)
            {
                if(board[row][column] != '.')
                {
                    if( isPossible(board, row, column) == false)
                    return false;

                }
            }
        }
        return true;
    }
    
    public static boolean isPossible(char[][] board, int row, int column)
    {
        //int i = row,j = column;
        for(int i = 0;i<9;i++)  //checking row
        {
            if(i == row)
            continue;
            else if( board[i][column] == board[row][column])
            {
                return false;
            }
        }

        for(int j = 0;j<9;j++)
        {
            if(j == column)
            continue;
            else if( board[row][j] == board[row][column])
            {
                return false;
            }
        }

        int m = row/3;
        m = m*3;

        int n = column/3;
        n=n*3;
        for(int i=m;i<m+3  ;i++)
        {
            for(int j=n;j<n+3 ;j++)
            {
                if(board[i][j] != '.')
                {
                    if(i==row && j==column)
                    continue;
                    else if( board[i][j] == board[row][column])
                    return false;
                }
            }
        }
        return true;
    }
}