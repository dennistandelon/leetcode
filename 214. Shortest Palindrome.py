class Solution(object):
    def shortestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """

        rev_s = s[::-1] 
        if rev_s == s:
            return s

        new_s = s + '#' + rev_s
        size = len(new_s)
        lps = [0] * size

        for i in range(1, size):
            j = lps[i - 1]
            while j > 0 and new_s[i] != new_s[j]:
                j = lps[j - 1]
            if new_s[i] == new_s[j]:
                j += 1
            lps[i] = j

        return rev_s[:len(s) - lps[-1]] + s
            

        
        
        