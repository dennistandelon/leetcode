class Solution(object):
    def maxEqualRowsAfterFlips(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        def get_flip_pattern(row):
            first_row_pattern = tuple(val ^ row[0] for val in row)
            return first_row_pattern
        
        pattern_count = Counter(get_flip_pattern(row) for row in matrix)
        
        return max(pattern_count.values())
        