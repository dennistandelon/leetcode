class Solution(object):
    def shortestSubarray(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """

        total_len = len(nums) + 1
        sum_count = [0] * (total_len)

        for i, num in enumerate(nums):
            sum_count[i+1] = sum_count[i] + num

        queue = deque()

        min_count = float('inf')

        for i in range(total_len):

            while queue and sum_count[i] - sum_count[queue[0]] >= k:
                min_count = min(min_count, i - queue.popleft())

            while queue and sum_count[i] <= sum_count[queue[-1]]:
                queue.pop()

            queue.append(i)

        return min_count if min_count != float('inf') else -1
        