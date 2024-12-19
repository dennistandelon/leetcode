class Solution(object):
    def finalPrices(self, prices):
        """
        :type prices: List[int]
        :rtype: List[int]
        """
        n = len(prices)
        for i, price in enumerate(prices):
            if i <= len(prices) - 1:
                for j in range(i+1, n):
                    if prices[j] <= price:
                        prices[i] = price - prices[j]
                        break
                

        return prices
