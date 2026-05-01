
# Problem Statement : https://leetcode.com/problems/binary-tree-maximum-path-sum/description/



class Solution:
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:

        res = []
        if root == None:
            return res

        val = root.val
        
        l1 = self.binaryTreePaths(root.left)
        l2 = self.binaryTreePaths(root.right)

        l = l1 + l2

        if len(l) == 0:
            return [f"{val}"]
            
        for i in range(len(l)):
            p = f"{val}->{l[i]}"
            res.append(p)
        
        return res