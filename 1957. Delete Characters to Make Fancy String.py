class Solution(object):
    def makeFancyString(self, s):
        """
        :type s: str
        :rtype: str
        """
        st = ''

        count = 0
        for i, x in enumerate(s):
            if i != 0 and x != s[i-1]:
                count = 0
            
            count = count + 1
            if count <= 2:
                st = st + x

        return st