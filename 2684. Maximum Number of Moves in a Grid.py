class Solution(object):
    def maxMoves(self, grid):
        m, n = len(grid), len(grid[0])
        dp = [[0] * n for _ in range(m)]

        for col in range(n - 1, -1, -1):
            for row in range(m):
                if col == n - 1:
                    dp[row][col] = 0
                else:
                    if row - 1 >= 0 and grid[row - 1][col + 1] > grid[row][col]:
                        dp[row][col] = max(dp[row][col], 1 + dp[row - 1][col + 1])
                    if grid[row][col + 1] > grid[row][col]:
                        dp[row][col] = max(dp[row][col], 1 + dp[row][col + 1])
                    if row + 1 < m and grid[row + 1][col + 1] > grid[row][col]:
                        dp[row][col] = max(dp[row][col], 1 + dp[row + 1][col + 1])


        max_moves = 0
        for row in range(m):
            max_moves = max(max_moves, dp[row][0])

        return max_moves