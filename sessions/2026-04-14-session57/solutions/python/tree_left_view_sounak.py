''' 
class Node:

    def __init__(self, val):
        self.data = val
        self.right = None
        self.left = None 
'''
from collections import deque

class Solution:
    def leftView(self, root):
        # code here
        q = deque()
        
        if root == None:
            return []
        
        q.append(root)
        res = []
        
        while q:
            leen = len(q)
            
            sw = 0
            for i in range(leen):
                t = q.popleft()
                if sw == 0:
                    res.append(t.data)
                    sw = 1
                
                if t.left:
                    q.append(t.left)
                
                if t.right:
                    q.append(t.right)
        
        return res
                
                
        