class Solution(object):
    def minimizedMaximum(self, n, quantities):
        """
        :type n: int
        :type quantities: List[int]
        :rtype: int
        """

        left = 1
        right = max(quantities)

        def distributable(num):
            count = 0

            for i in quantities:
                count += math.ceil((i + 0.0)/num)
            
            return count <= n

        while left < right:
            mid = (right + left)//2
            if distributable(mid):
                right = mid
            else:
                left = mid + 1

        return left