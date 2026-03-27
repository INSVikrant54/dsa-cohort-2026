class Solution {
    public List<List<String>> solveNQueens(int n) 
    {
        List<List<String>> res = new ArrayList<>();
        String[][] matrix = new String[n][n];
        
        for(int i = 0;i<n;i++)      //careful - forgot to add "." in every matrix got error
            {
                for(int j = 0;j<n;j++)
                {
                    matrix[i][j] = ".";
                }
            }
        queen(0 ,0 ,n ,matrix, res);

        return res;
    }

    public static void queen(int column, int row ,int n,String[][] matrix, List<List<String>> res)
    {
        if(column>=n)  //careful got error
        {
            List<String> list = new ArrayList<>();
            for(int i = 0;i<n;i++)
            {
                String str="";
                for(int j = 0;j<n;j++)
                {
                    str = str + matrix[i][j];
                }
                list.add(str);
            }            
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = row;i<n;i++)
        {
            if(check(i, column, n, matrix) && row < n && column< n)
            {   
                matrix[i][column] = "Q";
                queen(column+1,0 ,n, matrix, res);

                matrix[i][column] = ".";

            }
        }
    }
    public static boolean check(int i, int j, int n, String[][] matrix)
    {
        int row=i, column=j;  //careful got error
        while(row>=0 && column>=0 && row<n && column<n)  //LeftTop
        {
            if((matrix[row][column]).equals("Q"))   //careful got error
            return false;
            else
            {
                row--; column--;
            }
        }
        row=i;column=j;
        while(row>=0 && column>=0 && row<n && column<n)  //Left
        {
            if((matrix[row][column]).equals("Q"))
            return false;
            else
            {
                column--;
            }
        }
        row=i;column=j;
        while(row>=0 && column>=0 && row<n && column<n)  //LeftDown
        {
            if((matrix[row][column]).equals("Q"))
            return false;
            else
            {
                column--; row++;
            }
        }
        return true;
    }
}