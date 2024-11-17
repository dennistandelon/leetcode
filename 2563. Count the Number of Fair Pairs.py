class Solution(object):
    def countFairPairs(self, nums, lower, upper):
        """
        :type nums: List[int]
        :type lower: int
        :type upper: int
        :rtype: int
        """

        count = 0

        nums.sort()
        n = len(nums)

        def lower_bound(left, right):
            l = left
            r = right
            
            while l < r:
                mid = (l+r)//2
                if nums[i] + nums[mid] < lower:
                    l = mid + 1
                else:
                    r = mid
            return l

        def upper_bound(left, right):
            l = left
            r = right
            
            while l < r:
                mid = (l+r)//2
                if nums[i] + nums[mid] > upper:
                    r = mid
                else:
                    l = mid + 1
            return l

        for i in range(n):
            left, right = i + 1, n

            start = lower_bound(left, right)
            end = upper_bound(left, right)

            count = count + end - start

        return count

        