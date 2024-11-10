class Solution(object):
    def largestCombination(self, candidates):
        """
        :type candidates: List[int]
        :rtype: int
        """
        max_bits = max(candidates).bit_length()
        bit_counts = [0] * max_bits

        for num in candidates:
            for i in range(max_bits):
                if num & (1 << i):
                    bit_counts[i] += 1

        return max(bit_counts)
        