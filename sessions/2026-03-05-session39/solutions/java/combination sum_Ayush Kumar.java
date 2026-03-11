class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        //whenever we need to find combinations or subsets related problem - RECURSION is needed
        List<List<Integer>> res = new ArrayList<>();
        int sum_now=0;
        sum(target, 0, 0, candidates, new ArrayList<>(), res);
        return res;    
    }

    public static void sum(int target, int sum_now, int index, int[] candidates ,List<Integer> subsets, List<List<Integer>> res)
    {
        if(index>=candidates.length || sum_now>target)
        return;
        else if(sum_now==target)
        {
            res.add(new ArrayList<>(subsets));
            return;
        }
        subsets.add(candidates[index]);
        sum(target, (sum_now + candidates[index]), index, candidates, subsets, res);
        
        subsets.remove(subsets.size()-1);
        //subsets.remove((Integer)candidates[index]);
        sum(target, (sum_now), index+1, candidates, subsets, res);
        
    }
}