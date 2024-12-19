class Solution(object):
    def maximumLength(self, s):
        """
        :type s: str
        :rtype: int
        """
        length = len(s)

        str_dict = {}

        for i in range(length):
            if not s[i] in str_dict:
                str_dict[s[i]] = 1
            else:
                str_dict[s[i]] += 1

        for i in range(length):
            for j in range(1, length - i):
                if i + j >= length:
                    break
                if s[i+j] == s[i+j-1]:
                    if not s[i: i+j+1] in str_dict:
                        str_dict[s[i: i+j+1]] = 1
                    else:
                        str_dict[s[i: i+j+1]] += 1
                else:
                    break
        
        max_len = -1
        for i in str_dict:
            if str_dict[i] >= 3:
                max_len = max(max_len, len(i))
        
        return max_len

        