class Solution(object):
    def smallestChair(self, times, targetFriend):
        """
        :type times: List[List[int]]
        :type targetFriend: int
        :rtype: int
        """
        lent = len(times)
        events = [(times[i][0], times[i][1], i) for i in range(lent)]
        
        events.sort(key=lambda x: x[0])
        
        available_chairs = list(range(lent))
        heapq.heapify(available_chairs)
        
        occupied_chairs = []
        
        for arrival, leaving, friend_index in events:
            while occupied_chairs and occupied_chairs[0][0] <= arrival:
                leave_time, chair_number = heapq.heappop(occupied_chairs)
                heapq.heappush(available_chairs, chair_number)
                        
            assigned_chair = heapq.heappop(available_chairs)
            
            if friend_index == targetFriend:
                return assigned_chair
            
            heapq.heappush(occupied_chairs, (leaving, assigned_chair))



        