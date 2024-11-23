class Solution(object):
    def decrypt(self, code, k):
        """
        :type code: List[int]
        :type k: int
        :rtype: List[int]
        """
        result = []

        lenn = len(code)

        if k == 0:
            return [0] * lenn
        

        code.extend(code)

        if k > 0:
            for i in range(0, lenn):
                result.append(sum(code[i+1:i+1+k]))
        else:
            for i in range(lenn, len(code)):
                result.append(sum(code[i+k:i]))


        return result