class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int len = queries.length;
        int[] res = new int[len];

        for(int i=0; i < len; i++){
            int start = queries[i][0];
            int end = queries[i][1];

            res[i] = arr[start];
            for(int j = start + 1; j <= end; j++){
                res[i] = res[i] ^ arr[j];
            }
            
        }

        return res;
    }
}