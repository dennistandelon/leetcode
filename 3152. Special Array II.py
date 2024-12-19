class Solution(object):
    def isArraySpecial(self, nums, queries):
        """
        :type nums: List[int]
        :type queries: List[List[int]]
        :rtype: List[bool]
        """
        
        n = len(nums)
        d = list(range(n))
        for i in range(1, n):
            if nums[i] % 2 != nums[i - 1] % 2:
                d[i] = d[i - 1]
        return [d[t] <= f for f, t in queries]