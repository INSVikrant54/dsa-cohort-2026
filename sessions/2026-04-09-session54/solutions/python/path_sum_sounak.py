# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def ab(self, curr: int, targetSum: int, root: Optional[TreeNode]):
        if root == None:
            return False

        curr += root.val
        print(curr, targetSum)
        
        if root.left == None and root.right == None and curr == targetSum:
            return True


        l = self.ab(curr, targetSum, root.left)
        if l is not True:
            r = self.ab(curr, targetSum, root.right)
        return l or r

    
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        return self.ab(0, targetSum, root)
        
        