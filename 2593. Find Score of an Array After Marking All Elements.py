class Solution(object):
    def findScore(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        marked = [0 for i in nums]
        min_heap = [(index, i) for i, index in enumerate(nums)]

        heapq.heapify(min_heap)

        score = 0

        while min_heap:
            num, i = heapq.heappop(min_heap)
            
            if marked[i]:
                continue

            score += num
            for j in range(max(0, i - 1), min(n, i + 2)):
                marked[j] = True

        return score
           