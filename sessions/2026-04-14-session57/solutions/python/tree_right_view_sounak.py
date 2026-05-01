# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
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
                    res.append(t.val)
                    sw = 1
                
                if t.right:
                    q.append(t.right)
                
                if t.left:
                    q.append(t.left)
        
        return res
        