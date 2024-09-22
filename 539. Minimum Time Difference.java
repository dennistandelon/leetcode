class Solution {
    public int findMinDifference(List<String> timePoints) {
        
        int len = timePoints.size();
        int min = 9999;

        int[] arr = new int[len];
        for(int i=0; i < len; i++){
            String[] temp = timePoints.get(i).split(":");
            arr[i] = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);

            for(int j=i; j > 0; j--){
                if(arr[j] < arr[j-1]){
                    int t = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = t;
                }
            }
        }


        for(int i=1; i < len; i++){
            if(arr[i] - arr[i-1] < min){
                min = arr[i] - arr[i-1];
            }
        }

        if((arr[0] + 1440) - arr[len-1] < min){
            min = (arr[0] + 1440) - arr[len-1];
        }
    
        return min;
    }
}