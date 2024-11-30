class Solution(object):
    def shortestDistanceAfterQueries(self, n, queries):
        """
        :type n: int
        :type queries: List[List[int]]
        :rtype: List[int]
        """
        result = []

        init = {i:[i+1] for i in range(n-1)}
        init[n-1] = []

        def dijkstra():
            dist = [float('inf')] * n
            dist[0] = 0

            heap = [(0,0)]

            while heap:
                current_dist, node = heapq.heappop(heap)
                
                if node == n - 1:
                    return current_dist
                
                for neighbor in init[node]:
                    new_dist = current_dist + 1
                    if new_dist < dist[neighbor]:
                        dist[neighbor] = new_dist
                        heapq.heappush(heap, (new_dist, neighbor))
            
            return dist[n - 1]

        for u, v in queries:
            if v not in init[u]:
                init[u].append(v)
            
            result.append(dijkstra())
        
        return result