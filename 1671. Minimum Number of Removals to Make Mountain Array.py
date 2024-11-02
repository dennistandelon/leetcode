class Solution(object):
    def minimumMountainRemovals(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        def longest_increasing_subsequence(nums):

            if not nums:
                return []

            dp = []
            for num in nums:
                pos = bisect_left(dp, num)
                if pos == len(dp):
                    dp.append(num)
                else:
                    dp[pos] = num
            return dp

        def longest_decreasing_subsequence(nums):
            return longest_increasing_subsequence(nums[::-1])[::-1]

        n = len(nums)
        if n < 3:
            return 0

        lis = longest_increasing_subsequence(nums)
        lds = longest_decreasing_subsequence(nums)

        left_length = [0] * n
        right_length = [0] * n

        for i in range(n):
            left_length[i] = 1
            for j in range(i):
                if nums[j] < nums[i]:
                    left_length[i] = max(left_length[i], left_length[j] + 1)

        for i in range(n - 1, -1, -1):
            right_length[i] = 1
            for j in range(i + 1, n):
                if nums[j] < nums[i]:
                    right_length[i] = max(right_length[i], right_length[j] + 1)

        min_removals = float('inf')
        for i in range(1, n - 1):
            if left_length[i] > 1 and right_length[i] > 1:  # Valid peak
                total_length = left_length[i] + right_length[i] - 1
                min_removals = min(min_removals, n - total_length)

        return min_removals if min_removals != float('inf') else 0

    