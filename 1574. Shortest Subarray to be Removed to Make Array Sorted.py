class Solution(object):
    def findLengthOfShortestSubarray(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        lenn = len(arr)

        prefix = 0
        for i in range(1,lenn):
            if arr[i] < arr[i-1]:
                prefix = i
                break
        
        suffix = 0
        for i in range(lenn-1,0,-1):
            if arr[i] < arr[i-1]:
                suffix = i
                break
        
        prefix -= 1

        i, j = 0, suffix

        count = min(lenn - prefix - 1, suffix)
        while i <= prefix and j < lenn:
            if arr[i] <= arr[j]:
                count = min(count,j-i-1)
                i+=1
            else:
                j+=1
        
        return count