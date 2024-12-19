class Solution(object):
    def maxTwoEvents(self, events):
        """
        :type events: List[List[int]]
        :rtype: int
        """
        lenn = len(events)

        events.sort()

        memo = [[-1, -1, -1] for i in events]

        def findNextIndex(idx):
            low, high = idx+1, lenn -1 
            while low <= high:
                mid = (low+high)/2

                if events[mid][0] > events[idx][1]:
                    high = mid-1;
                else:
                     low  = mid+1

            return low


        def maxEv(idx, k):

            if idx == lenn or k == 0:
                return 0

            if memo[idx][k] != -1:
                return memo[idx][k]

            take = 0;
            nextIdx = findNextIndex(idx)
            take = max(take, events[idx][2] + maxEv(nextIdx,k-1))
        
            dontTake = maxEv(idx+1,k)

            memo[idx][k] = max(take,dontTake)
            return memo[idx][k]

        return maxEv(0, 2)
        