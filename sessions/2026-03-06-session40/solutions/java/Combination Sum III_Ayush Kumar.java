class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) 
    {
        List<List<Integer>> res = new ArrayList<>();

        int[] arr = {1,2,3,4,5,6,7,8,9};
        Combination(0,0, k , n , new ArrayList<>() , arr ,res  );

        return res;
    }

    public static void Combination(int index ,int sum, int len , int target , List<Integer> subsets , int[] arr, List<List<Integer>> res)
    {
        if(sum==target && subsets.size()==len)
        {
            res.add(new ArrayList<>(subsets));
            return;
        }
        else if(index>=arr.length || subsets.size() > len || sum>target)
        return;
        

        subsets.add(arr[index]);
        Combination(index+1,sum+arr[index],len,target,subsets,arr,res);

        subsets.remove((Integer)arr[index]);
        Combination(index+1,sum,len,target,subsets,arr,res);
    }
}