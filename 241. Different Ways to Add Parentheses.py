class Solution(object):
    def diffWaysToCompute(self, expression):
        """
        :type expression: str
        :rtype: List[int]
        """
        memo = {}

        def divide(exp):

            if exp in memo:
                return memo[exp]

            arr = []

            for i, x in enumerate(exp):
                if x in '-+*':
                    left_res = divide(exp[:i])
                    right_res = divide(exp[i+1:])

                    for left in left_res:
                        for right in right_res:
                            if x == '+':
                                arr.append(left + right)
                            elif x == '-':
                                arr.append(left - right)
                            elif x == '*':
                                arr.append(left * right)

            if len(arr) == 0:
                arr.append(int(exp))
        
            memo[exp] = arr
            return memo[exp]

        return divide(expression)