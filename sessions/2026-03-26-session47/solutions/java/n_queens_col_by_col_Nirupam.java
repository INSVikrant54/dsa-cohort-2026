// col by col starting from 1st col, moving towards nth col.

class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        List<List<String>> res = new ArrayList<>();

        char[][] board = new char[n][n];
        for(char[] row : board){
            Arrays.fill(row , '.');
        }

        resc(0 , board , res , n);
        return res;
    }

    private void resc(int col , char[][] board , List<List<String>> res, int n){

        if(col == n){
            res.add(construct(board));
            return;
        }
        // move to each row one by one in each col
        for(int row=0; row < n ; row++)
        {
            if(isPossible(row , col , board ,n)){
                board[row][col] ='Q';

                resc(col+1,board,res,n); // move to next col

                board[row][col] = '.';
            }
        }
    }

    private boolean isPossible(int row , int col , char[][]board , int n){
        int r= row, c = col;

        // top left check;
        while(r>=0 && c>=0) {
            if(board[r][c] == 'Q'){
                return false;
            }
            c--;
            r--;
        }

        // bottom left;
        r=row;
         c=col;
        while(r<n && c>=0){
            if(board[r][c]=='Q')
            return false;

            c--;
            r++;
        }

        // left
        r=row;
        c=col;
        while(c>=0){
            if(board[r][c] == 'Q'){
                return false;
            }
            c--;
        }

        return true;
    }

// coverting the rows to list
    private List<String> construct(char[][] board){
        List<String> list = new ArrayList<>();
        for(char[] row:board){
            list.add(new String(row));
        }
        return list;
    }
}