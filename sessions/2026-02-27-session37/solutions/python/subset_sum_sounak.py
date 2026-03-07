from sys import *
from collections import *
from math import *

from typing import List

def subsetSum(num: List[int]) -> List[int]:
    # Write your code here.
    n = len(num)
    i = 0
    subset = []
    res = []
    summ = 0
    def df(i, summ):
        if i >= n:
            res.append(summ)
            return
        
        subset.append(num[i])
        # carry over the sum to avoid re-calculating everytime
        df(i+1, summ+num[i])

        # pop the added element
        subset.pop()
        df(i+1, summ)

    df(i, summ)

    res.sort()

    return res