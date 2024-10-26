# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def kthLargestLevelSum(self, root, k):
        """
        :type root: Optional[TreeNode]
        :type k: int
        :rtype: int
        """
        level_data = {}

        def traverse(node, level):

            if not level in level_data:
                level_data[level] = 0
            level_data[level] = level_data[level] + node.val
            print(level, " >> ", node.val)

            if node.left is not None:
                traverse(node.left, level+1)
        
            if node.right is not None:
                traverse(node.right, level+1)
            
        traverse(root,0)

        result = [x for x in level_data.values()]
        result.sort(reverse=True)
        
        if k > len(result):
            return -1
        
        return result[k-1]