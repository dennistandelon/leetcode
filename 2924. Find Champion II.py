class Solution(object):
    def findChampion(self, n, edges):
        """
        :type n: int
        :type edges: List[List[int]]
        :rtype: int
        """
        
        winner_set = set()
        lose_set = set()
        all_set = set()

        if len(edges) == 0:
            return  0 if n == 1 else -1

        for edge in edges:
            winner_set.add(edge[0])
            lose_set.add(edge[1])
            all_set.add(edge[0])
            all_set.add(edge[1])

        if n > len(all_set):
            return -1

        for i in lose_set:
            if i in winner_set:
                winner_set.remove(i)

        if len(winner_set) != 1:
            return -1
        
        return winner_set.pop()