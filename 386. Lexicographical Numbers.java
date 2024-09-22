class Solution {
    public List<Integer> lexicalOrder(int n) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        

        for(Integer i=1; i <= 9; i++){
            if(i <= n){
                arr.add(i);
                dfs(i,n,arr);
            }
        }

        return arr;
    }

    public void dfs(int curr, int max, ArrayList<Integer> num){

        if(curr > max){
            return;
        }

        int temp;
        for(int i=0; i < 10; i++){
            temp = curr * 10 + i;

            if(temp > max){
                return;
            }
            
            num.add(temp);
            dfs(temp,max,num);
        }
    }
}