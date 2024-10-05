class Solution(object):
    def canArrange(self, arr, k):
        """
        :type arr: List[int]
        :type k: int
        :rtype: bool
        """
        remainder_count = [0] * k

        for num in arr:
            remainder = num % k
            if remainder < 0:
                remainder += k
            remainder_count[remainder] += 1

        for r in range(k):
            if r == 0:  
                if remainder_count[r] % 2 != 0:
                    return False
            elif r <= k // 2:
                if remainder_count[r] != remainder_count[k - r]:
                    return False

        return True
        