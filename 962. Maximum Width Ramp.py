class Solution(object):
    def maxWidthRamp(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        index = list(range(len(nums)))
        index.sort(key=lambda x: nums[x])

        min_idx = float("inf")
        max_width = 0

        for i in index:
            max_width = max(max_width, i - min_idx)
            min_idx = min(min_idx, i)

        return max_width
        