class Solution(object):
    def resultsArray(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """

        diff = []

        total_len = len(nums)
        for i in range(1, total_len):
            diff.append(nums[i] - nums[i-1])

        result = []

        for i in range(total_len - k + 1):
            is_consecutive = all(diff[j] == 1 for j in range(i, i + k - 1))
            if is_consecutive:
                result.append(max(nums[i:i + k]))
            else:
                result.append(-1)

        return result