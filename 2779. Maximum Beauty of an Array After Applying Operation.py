class Solution(object):
    def maximumBeauty(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        events = []
    
        for num in nums:
            events.append((num - k, 1))
            events.append((num + k + 1, -1))

        events.sort()
        
        max_beauty = 0
        current_count = 0

        for pos, effect in events:
            current_count += effect
            max_beauty = max(max_beauty, current_count)

        return max_beauty
                
