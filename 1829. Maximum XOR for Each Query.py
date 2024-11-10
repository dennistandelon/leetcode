class Solution(object):
    def getMaximumXor(self, nums, maximumBit):
        """
        :type nums: List[int]
        :type maximumBit: int
        :rtype: List[int]
        """
        max_val = (1 << maximumBit) - 1  
        totalXOR = 0

        for num in nums:
            totalXOR ^= num

        answer = []
        
        for num in reversed(nums):
            answer.append(totalXOR ^ max_val)
            totalXOR ^= num

        return answer
            