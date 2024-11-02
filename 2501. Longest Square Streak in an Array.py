class Solution(object):
    def longestSquareStreak(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums = set(nums)
        sequence = {}

        def findNext(num):

            if num in sequence:
                return sequence[num]

            if not (num * num) in nums:
                return 1
            
            sequence[num] = 1 + findNext(num * num)
            return sequence[num]
        
        max_seq = 0
        for i in nums:
            max_seq = max(max_seq, findNext(i))

        if(max_seq == 1):
            return -1 
        return max_seq