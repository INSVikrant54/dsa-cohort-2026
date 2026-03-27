class Solution {
    public List<List<String>> partition(String s) 
    {
        List<List<String>> res = new ArrayList<>();
        substring(0,res,new ArrayList<>(),s);

        return res;
    }
    public static void substring(int index ,List<List<String>> res ,List<String> list ,String s)
    {
        if(index>=s.length())
        {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = index;i<s.length() ; i++)
        {
            String substring = s.substring(index,i+1); 
            if(palindrome(substring))
            {
                list.add(substring);

                substring(i+1, res, list, s);
                list.remove(list.size()-1);
            }
        }
    }
    public static boolean palindrome(String s)
    {
        //char[] array = s.toCharArray();
        int left=0 , right = s.length()-1; 
        //int right = array.length-1;
        while(left<=right)
        {
            if(s.charAt(right)==s.charAt(left))
            {
                left++;
                right--;
            }
            else
            return false;
        }
        // while(left<=right)
        // {
        //     if(array[left] == (array[right]))
        //     {
        //         left++;
        //         right--;
        //     }
        //     else
        //     return false;
        // }
        return true;


        
    }


}