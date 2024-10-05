class Solution(object):
    def minSubarray(self, nums, p):
        """
        :type nums: List[int]
        :type p: int
        :rtype: int
        """
        total = sum(nums)

        if total % p == 0:
            return 0

        prefix_index = {0:-1}
        prefix_sum = 0

        len1 = len(nums)

        for i, num in enumerate(nums):
            prefix_sum = prefix_sum + num

            mod = prefix_sum % p
            
            find = (mod - (total % p)) % p

            if find in prefix_index:
                len1 = min(len1, i - prefix_index[find])

            prefix_index[mod] = i

        return len1 if len1 < len(nums) else prefix_index[0]
        