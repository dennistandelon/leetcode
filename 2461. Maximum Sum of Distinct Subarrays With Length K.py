class Solution(object):
    def maximumSubarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """

        max_res = 0
        total = 0
        temp = {}
        for i in range(0, k):
            total += nums[i]
            temp[nums[i]] = temp.get(nums[i], 0) + 1

        if len(temp) == k:
            max_res = max(max_res, total)

        for i in range(k, len(nums)):
            total += nums[i]
            temp[nums[i]] = temp.get(nums[i], 0) + 1


            if i >= k:
                left = nums[i - k]
                total -= left
                temp[left] -= 1
                if temp[left] == 0:
                    del temp[left]


            if len(temp) == k:
                max_res = max(max_res, total)
        
        return max_res

        
        