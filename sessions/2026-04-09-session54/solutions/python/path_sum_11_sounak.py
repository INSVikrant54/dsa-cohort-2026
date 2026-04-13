# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def ab(self, root: Optional[TreeNode], targetSum: int, curr: int, path: list[int], res: list[list[int]]):
        if root == None:
            return

        curr += root.val
        path.append(root.val)

        if root.left == None and root.right == None and curr == targetSum:
            res.append(path.copy())
        
        self.ab(root.left, targetSum, curr, path, res)
        self.ab(root.right, targetSum, curr, path, res)
        path.pop()

        
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        res = []
        self.ab(root, targetSum, 0, [], res)
        return res