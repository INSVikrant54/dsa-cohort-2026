class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()

        print(candidates)
        
        res = []
        subset = []
        
        def df(i, summ):
            if summ == target:
                res.append(subset.copy())
                return
            elif summ > target:
                return
            
            if i == len(candidates):
                return

            
            subset.append(candidates[i])
            df(i+1, summ + candidates[i])
            subset.pop()

            while i < len(candidates) - 1 and candidates[i] == candidates[i+1]:
                i += 1
            
            df(i+1, summ)
        
        df(0, 0)
        return res


         


        