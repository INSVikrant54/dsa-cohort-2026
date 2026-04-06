class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        ArrayList<String> res = new ArrayList<>();
        
        
        resc(maze , 0 , 0 , "" , res);
        Collections.sort(res); // sorting important
        return res;
    }
    
    private void resc(int[][]maze , int row , int col , String currPath , ArrayList<String> res) {
        
        int n = maze.length;
        
        if(row < 0 || row > n-1 || col <0 || col > n-1) {
            return ;
        }
        
        if(maze[row][col] == 0){
            return;
        }
        
        if(row ==n-1 && col == n-1) {
           res.add(currPath);
            
            return;
        }
        
        
        
        maze[row][col]=0;
        
        //up
        resc(maze , row-1 , col , currPath+"U" , res);
        //down
        resc(maze , row+1 , col , currPath+"D" , res);
        //right
        resc(maze , row , col+1 , currPath+"R" , res);
        //left
        resc(maze , row , col-1 , currPath+"L" , res);

        //diagonals check 
        
        //up-right
        resc(maze , row-1 , col+1 , currPath+"UR" , res);
        //up-left
        resc(maze , row-1 , col-1 , currPath+"UL" , res);
        //down-right
        resc(maze , row+1 , col+1 , currPath+"DR" , res);
        //down-left
        resc(maze , row+1 , col-1 , currPath+"DL" , res);
        
        maze[row][col]=1;
    }
}