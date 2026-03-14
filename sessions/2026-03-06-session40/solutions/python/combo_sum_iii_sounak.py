class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        res = []
        ans = []
        def df(i, summ):
            if summ > n or len(ans) > k:
                return
            elif summ == n and len(ans) == k:
                res.append(ans.copy())
                return
            
            # if the numbers needed to complete the required list is more than the available numbers, we can return
            if abs(k - len(ans)) > 9 - i:
                return

            if i >= 9:
                return

            el = i + 1
            ans.append(el)
            

            df(i+1, summ + el)
            ans.pop()
            df(i+1, summ)
        
        df(0,0)

        return res
    




    