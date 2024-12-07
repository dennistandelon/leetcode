class Solution(object):
    def canMakeSubsequence(self, str1, str2):
        """
        :type str1: str
        :type str2: str
        :rtype: bool
        """
        n, m = len(str1), len(str2)
        i = j = 0

        while i < n and j < m:
            if str1[i] == str2[j]:
                i += 1
                j += 1
            elif chr(((ord(str1[i]) - ord('a') + 1) % 26) + ord('a')) == str2[j]:
                i += 1
                j += 1
            else:
                i += 1
        
        return j == m