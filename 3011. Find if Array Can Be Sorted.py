class Solution(object):
    def canSortArray(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """

        def count_set_bits(x):
            return bin(x).count('1')

        lens = len(nums)

        for i in range(0, lens - 1):
            for j in range(0, lens - 1 - i):
                if nums[j] > nums[j+1] and count_set_bits(nums[j]) == count_set_bits(nums[j+1]):
                    temp = nums[j]
                    nums[j] = nums[j+1]
                    nums[j+1] = temp
        

        for i in range(1, lens):
            if nums[i] < nums[i-1]:
                return False

        return True