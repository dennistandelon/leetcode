class Solution(object):
    def minimumTotalDistance(self, robot, factory):
        """
        :type robot: List[int]
        :type factory: List[List[int]]
        :rtype: int
        """
        robot.sort()
        factory.sort()

        rlen = len(robot)
        flen = len(factory)
        
        dp = [[float('inf')] * (flen + 1) for _ in range(rlen + 1)]
        dp[0][0] = 0

        for j in range(1, flen + 1):
            factory_pos, factory_limit = factory[j - 1]
            dp[0][j] = 0
            
            for i in range(1, rlen + 1):
                dp[i][j] = dp[i][j - 1]
                
                cost = 0
                for k in range(1, min(factory_limit, i) + 1):
                    cost += abs(robot[i - k] - factory_pos)
                    dp[i][j] = min(dp[i][j], dp[i - k][j - 1] + cost)

        return dp[rlen][flen]

        