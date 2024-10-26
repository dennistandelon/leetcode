# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def replaceValueInTree(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: Optional[TreeNode]
        """
        level_sum = {}
        def traverse_node(node, level):
            if not level in level_sum:
                level_sum[level] = 0

            level_sum[level] = level_sum[level] + node.val
            print(level, "|", level_sum[level])

            if not node.left is None:
                traverse_node(node.left, level+1)
            if not node.right is None:
                traverse_node(node.right, level+1)

        def new_sum(node, sibling, level):
            if node is None:
                return

            if sibling is None:
                node.val = level_sum[level] - node.val
            else: 
                node.val = level_sum[level] - (node.val + sibling)

            if node.right is None:
                sibling_val_right = None
            else:
                sibling_val_right = node.right.val

            if node.left is None:
                sibling_val_left = None
            else:
                sibling_val_left = node.left.val

            new_sum(node.left, sibling_val_right, level+1)
            new_sum(node.right, sibling_val_left, level+1)

        traverse_node(root, 0)
        new_sum(root, None, 0)

        return root