class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        subset(candidates , target , new ArrayList<>() , 0 , 0 , list);
        return list;
    }

    public static void subset(int[] candidates , int target, List<Integer> subsets, int index, int sum , List<List<Integer>> res)
    {
        if(sum==target)
        {
            //if(res.contains(subsets))
            //return;
            res.add(new ArrayList<>(subsets));
            return;
        }
        else if(index>=candidates.length || sum>target)
        return;

        subsets.add(candidates[index]);
        subset(candidates , target , subsets , index+1 , sum + candidates[index] , res);

        //subsets.remove((Integer) candidates[index]);
        subsets.remove(subsets.size()-1);
        while(index<candidates.length-1 && candidates[index] == candidates[index+1])
        index++;
        subset(candidates , target , subsets , index+1  , sum , res);

    }
}