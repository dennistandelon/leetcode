class Solution(object):
    def checkIfExist(self, arr):
        """
        :type arr: List[int]
        :rtype: bool
        """
        n = len(arr)

        arr.sort()

        for i in range(n):
            for j in range(n):
                if arr[i] * 2 == arr[j] and i != j:       
                    return True

        return False