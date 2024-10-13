class Solution(object):
    def minGroups(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: int
        """
        
        events = []

        for left, right in intervals:
            events.append((left,1))
            events.append((right + 1,-1))
        
        events.sort()

        max_overlap = 0
        active_interval = 0

        for event in events:
            print(active_interval, event)
            active_interval = active_interval + event[1]
            max_overlap = max(max_overlap, active_interval)

        return max_overlap

                
