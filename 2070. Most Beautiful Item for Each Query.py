class Solution(object):
    def maximumBeauty(self, items, queries):
        """
        :type items: List[List[int]]
        :type queries: List[int]
        :rtype: List[int]
        """

        # for result
        result = [0] * len(queries)

        # sort item by price
        newSorted = sorted(items, key=lambda x: x[0])
        
        # Precompute value of beautry (From 0 until current)
        max_beauty = 0
        beauty_prices = []
        for price, beauty in newSorted:
            max_beauty = max(max_beauty, beauty)
            beauty_prices.append((price,max_beauty))

        
        newQ = sorted((idx, q) for idx, q in enumerate(queries))
        prices, beauties = zip(*beauty_prices)
        
        for idx, q in newQ:
            pos = bisect_right(prices, q) - 1
            if pos >= 0:
                result[idx] = beauties[pos]
        
        return result

        
