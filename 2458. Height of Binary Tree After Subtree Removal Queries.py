# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def treeQueries(self, root, queries):
        """
        :type root: Optional[TreeNode]
        :type queries: List[int]
        :rtype: List[int]
        """

        node_level = {}
        def traverse(node, level, level_depths):
            if not node:
                return -1
            
            node_level[node.val] = level
            
            left_depth = 1 + traverse(node.left, level + 1, level_depths)
            right_depth = 1 + traverse(node.right, level + 1, level_depths)
            max_depth = max(left_depth, right_depth)

            if max_depth > level_depths[level][0][1]:
                level_depths[level][1] = level_depths[level][0]
                level_depths[level][0] = (node.val, max_depth)
            elif max_depth > level_depths[level][1][1]:
                level_depths[level][1] = (node.val, max_depth)

            return max_depth

        level_depths = [[(-1, -1), (-1, -1)] for _ in range(100001)]
        
        max_tree_height = traverse(root, 0, level_depths)
        
        result = []
        for query in queries:
            current_level = node_level[query]
            highest, second_highest = level_depths[current_level]

            if highest[0] == query:
                new_height = second_highest[1] + current_level if second_highest[0] != -1 else current_level - 1
            else:
                new_height = max_tree_height
            
            result.append(new_height)
        
        return result