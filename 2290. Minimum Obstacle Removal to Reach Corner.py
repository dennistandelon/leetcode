class Solution(object):
    def minimumObstacles(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        
        m, n = len(grid), len(grid[0])
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)] 

        pq = [(0, 0, 0)]
        visited = [[float('inf')] * n for _ in range(m)]
        visited[0][0] = grid[0][0] 
        
        while pq:
            obstacles_removed, x, y = heapq.heappop(pq)
            
            if (x, y) == (m - 1, n - 1):
                return obstacles_removed
            
            for dx, dy in directions:
                nx, ny = x + dx, y + dy
                
                if 0 <= nx < m and 0 <= ny < n:
                    new_obstacles = obstacles_removed + grid[nx][ny]
                    
                    if new_obstacles < visited[nx][ny]:
                        visited[nx][ny] = new_obstacles
                        heapq.heappush(pq, (new_obstacles, nx, ny))
                        
        return -1 

