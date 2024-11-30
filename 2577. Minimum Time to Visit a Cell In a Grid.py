class Solution(object):
    def minimumTime(self,grid):
        m, n = len(grid), len(grid[0])
    
        if grid[0][1] > 1 and grid[1][0] > 1:
            return -1
        
        pq = [(0, 0, 0)]
        visited = [[float('inf')] * n for _ in range(m)]
        
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        
        while pq:
            time, x, y = heapq.heappop(pq)
            
            if (x, y) == (m - 1, n - 1):
                return time
            
            if time >= visited[x][y]:
                continue
            
            visited[x][y] = time
            
            for dx, dy in directions:
                new_x, new_y = x + dx, y + dy
                
                if 0 <= new_x < m and 0 <= new_y < n:
                    next_time = max(time + 1, grid[new_x][new_y])
                    
                    if (next_time - time - 1) % 2 != 0:
                        next_time += 1
                    
                    if next_time < visited[new_x][new_y]:
                        heapq.heappush(pq, (next_time, new_x, new_y))
        
        return -1