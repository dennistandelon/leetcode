class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        long highest_min = -1000000;
        long lowest_max = 1000000;
        long count_of_min = 0;
        long count = 0;

        for(int i=0; i < row; i++){
            for(int j= 0; j < col; j++){
                if(matrix[i][j] <= 0){
                    count -= matrix[i][j];
                    highest_min = Math.max(highest_min, matrix[i][j]);
                    count_of_min++;
                } else {
                    count += matrix[i][j];
                    lowest_max = Math.min(lowest_max, matrix[i][j]);
                }
            }
        }

        if(count_of_min % 2 == 0){
            return count;
        }


        return count + (-2 * Math.min(highest_min * -1, lowest_max));
    }
}