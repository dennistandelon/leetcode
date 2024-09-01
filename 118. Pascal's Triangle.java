class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> nums;

        nums = new ArrayList<List<Integer>>();
        for(int i=0; i <= numRows; i++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int j = 0; j < i; j++){
                if(j == 0 || j == (i-1)){
                    temp.add(1);
                } else{
                    temp.add(nums.get(i-1).get(j) + nums.get(i-1).get(j-1));
                }
            }
            nums.add(temp);
        }

        nums.remove(0);
        return nums;
    }
}