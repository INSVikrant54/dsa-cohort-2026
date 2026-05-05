//row by row starting from 1st row, moving towards nth row.
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

    private void resc(int row , char[][] board , List<List<String>> res, int n){

        if(row == n){
            res.add(construct(board));
            return;
        }
        // move to each col one by one in each row
        for(int col=0; col < n ; col++)
        {
            if(isPossible(row , col , board ,n)){
                board[row][col] ='Q';

                resc(row+1,board,res,n); // move to next col

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

        // top right;
        r=row;
         c=col;
        while(c<n && r>=0){
            if(board[r][c]=='Q')
            return false;

            c++;
            r--;
        }

        // up
        r=row;
        c=col;
        while(r>=0){
            if(board[r][c] == 'Q'){
                return false;
            }
            r--;
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