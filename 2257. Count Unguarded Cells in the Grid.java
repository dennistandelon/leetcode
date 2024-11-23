class Solution {
    char map[][];
    int maxX;
    int maxY;
    
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        map = new char[m][n];
        maxX = m;
        maxY = n;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = '0';
            }
        }

        for(int[] wall: walls){
            map[wall[0]][wall[1]] = '#';
        }

        for(int[] arr: guards){
            map[arr[0]][arr[1]] = 'G';
        }
        
        for(int[] arr: guards){
            move(arr);
        }

        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == '0'){
                    count++;
                }
            }
        }

        return count;
    }

    public void move(int[] arr){
        moveLeft(arr[0]-1,arr[1]);
        moveRight(arr[0]+1,arr[1]);
        moveUp(arr[0],arr[1]-1);
        moveDown(arr[0],arr[1]+1);
    }

    public void moveLeft(int x, int y){
        if(x < 0 || map[x][y] == '#' || map[x][y] == 'G'){
            return;
        }

        map[x][y] = '1';
        moveLeft(x-1,y);
    }

    public void moveRight(int x, int y){
        if(x >= maxX ){
            return;
        }

        if(map[x][y] == '#' || map[x][y] == 'G'){
            return;
        }

        map[x][y] = '1';
        moveRight(x+1,y);
    }

    public void moveUp(int x, int y){
        if(y < 0 || map[x][y] == '#' || map[x][y] == 'G'){
            return;
        }

        map[x][y] = '1';
        moveUp(x,y-1);
    }

    public void moveDown(int x, int y){
        if(y >= maxY || map[x][y] == '#' || map[x][y] == 'G'){
            return;
        }

        map[x][y] = '1';
        moveDown(x,y+1);
    }
}