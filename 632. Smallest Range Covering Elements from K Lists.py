class Solution(object):
    def smallestRange(self, nums):
        """
        :type nums: List[List[int]]
        :rtype: List[int]
        """
        pq = []

        max_num = float("-inf")

        lenn = len(nums)
        for i in range(lenn):
            heapq.heappush(pq, (nums[i][0],i,0))
            max_num = max(max_num, nums[i][0])
        
        best = [float("-inf"), float("inf")]

        while pq:

            min_num, i_row, i_data = heapq.heappop(pq)

            if max_num - min_num < best[1] - best[0]:
                best = [min_num, max_num]

            if i_data + 1 < len(nums[i_row]):
                new_data = nums[i_row][i_data+1]
                heapq.heappush(pq, (nums[i_row][i_data+1], i_row, i_data+1))
                max_num = max(max_num, new_data)
            else:
                break

        return best
        