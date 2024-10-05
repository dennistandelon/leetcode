class Solution(object):
    def arrayRankTransform(self, arr):
        """
        :type arr: List[int]
        :rtype: List[int]
        """
        if len(arr) == 0:
            return []

        arr2 = sorted(set(arr))

        rank_dict = {val: i + 1 for i, val in enumerate(arr2)}

        return [rank_dict[x] for x in arr]