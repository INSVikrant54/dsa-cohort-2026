class Solution:
    def combinationSum(self, candidates: list[int], target: int) -> List[List[int]]:
        res = []
        subset = []
        def df(i, summ):
            if i >= len(candidates):
                return
            if summ > target:
                return
            elif summ == target:
                res.append(subset.copy())
                return
            

            subset.append(candidates[i])
            df(i, summ + candidates[i])
            subset.pop()
            df(i+1, summ)
        
        df(0, 0)
        return res