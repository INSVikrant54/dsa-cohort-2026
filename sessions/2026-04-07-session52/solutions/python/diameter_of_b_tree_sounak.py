# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    maxx = -1

    def ab(self, root: Optional[TreeNode]) -> int:
        if root == None:
            return 0
        
        l = self.ab(root.left)
        r = self.ab(root.right)

        self.maxx = max(self.maxx, l+r)
        return 1 + max(l,r)


    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        m = self.ab(root)
        return self.maxx

        