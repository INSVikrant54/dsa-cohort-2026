/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) 
    {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> seen = new HashSet<>();

        int distance = 0;
        if(root == null)
        return list;

        Map<TreeNode,TreeNode> map = new HashMap<>();
        map.put(root ,null);
        Traverse(root, map);

        queue.add(target);
        seen.add(target);

        while(!queue.isEmpty())
        {
            int size = queue.size();

            if(distance == k)
            {
                while(!queue.isEmpty())
                list.add(queue.remove().val);

                break;
            }
            for(int i =0;i<size;i++)
            {
                TreeNode node = queue.remove();

                if(node.left != null && !seen.contains(node.left))
                {
                    queue.add(node.left);
                    seen.add(node.left);
                }

                if(node.right!=null && !seen.contains(node.right))
                {
                    queue.add(node.right);
                    seen.add(node.right);
                }
                

                if(map.get(node) != null && !seen.contains(map.get(node)))
                {
                    queue.add(map.get(node));
                    seen.add(map.get(node));
                }
            }
            distance++;
        } 
        return list;
    }

    public void Traverse(TreeNode root, Map<TreeNode,TreeNode> map)
    {
        if(root==null)
        return;
        
        if(root.left != null)
        {
            Traverse(root.left,map);
            map.put(root.left, root);
        }

        if(root.right != null)
        {
            Traverse(root.right,map);
            map.put(root.right, root);
        }


    }
}


