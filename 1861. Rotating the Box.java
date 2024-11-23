class Solution {
    public char[][] rotateTheBox(char[][] box) {
        
        int row = box.length;
        int column = box[0].length;

        char[][] rotatedBox = new char[column][row];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                rotatedBox[j][i] = box[row - 1 - i][j];
            }
        }

        for(int j = 0; j < row; j++){
            for(int i = column-1; i > 0; i--){
                if(rotatedBox[i-1][j] == '#'){
                    int curr = i;
                    while(curr < column && rotatedBox[curr][j] == '.'){
                        rotatedBox[curr-1][j] = '.';
                        rotatedBox[curr][j] = '#';
                        curr++;
                    }
                }
            }
        }

        

        return rotatedBox;

    }
}