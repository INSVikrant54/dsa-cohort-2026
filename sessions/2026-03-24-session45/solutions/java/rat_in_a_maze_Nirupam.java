class Solution {
    public ArrayList<String> ratInMaze(int[][] maze ,int k) {
        // code here
        ArrayList<String> res = new ArrayList<>();
        
        if (maze[0][0] == 0) return res;
        
        int n = maze.length;

        int[][] visitCount = new int[n][n];
        
        resc(maze , 0 , 0 , "" , res ,visitCount,k);
        Collections.sort(res); // sorting important
        return res;
    }
    
    private void resc(int[][]maze , int row , int col , String currPath , ArrayList<String> res ,int[][] visitCount, int k) {
        
        int n = maze.length;
        
        if(row < 0 || row > n-1 || col <0 || col > n-1) {
            return ;
        }
        // revisit limit check
        if (visitCount[row][col] >= k) {
            return;
        }
        
        if(maze[row][col] == 0){
            return;
        }
        
        if(row ==n-1 && col == n-1) {
           res.add(currPath);
            
            return;
        }
        

        // Increase the visitcount of the current cell
        visitCount[row][col]++;
        
        //up
        resc(maze , row-1 , col , currPath+"U" , res ,visitCount , k);
        //down
        resc(maze , row+1 , col , currPath+"D" , res,visitCount , k);
        //right
        resc(maze , row , col+1 , currPath+"R" , res,visitCount , k);
        //left
        resc(maze , row , col-1 , currPath+"L" , res,visitCount , k);
        
        // backtrack
        visitCount[row][col]--; // drease the visitCount of the cell
    }
}