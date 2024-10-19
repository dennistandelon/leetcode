class Solution(object):
    def maxKelements(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """

        list_num = [-n for n in nums]
        heapq.heapify(list_num)

        max = 0
        for i in range(k):
            num = -1 * heapq.heappop(list_num)
            max = max + num
            num = int(math.ceil(float(num)/3))
            heapq.heappush(list_num,-1 * num)

        return max
        