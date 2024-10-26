class Solution(object):
    def parseBoolExpr(self, expression):
        """
        :type expression: str
        :rtype: bool
        """
        return self.parse(expression)

    def parse(self, exp):

        if exp == "t":
            return True
        elif exp == "f":
            return False

        if exp[0] == "!":
            return not self.parse(exp[2:-1])
        
        if exp[0] == "&":    
            exps = self.split(exp[2:-1])
            return all(self.parse(e) for e in exps)
        
        if exp[0] == '|': 
            exps = self.split(exp[2:-1])
            return any(self.parse(e) for e in exps)

    def split(self, expr):
        result = []
        balance = 0
        current = []
        for char in expr:
            if char == '(':
                balance += 1
            elif char == ')':
                balance -= 1
            elif char == ',' and balance == 0:
                result.append(''.join(current))
                current = []
                continue
            current.append(char)
        result.append(''.join(current))
        return result