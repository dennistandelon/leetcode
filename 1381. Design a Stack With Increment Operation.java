class CustomStack {
    int max;
    ArrayList<Integer> arr;

    public CustomStack(int maxSize) {
        max = maxSize;    
        arr = new ArrayList<Integer>();
    }
    
    public void push(int x) {
        if(arr.size() + 1 > max) return;
        arr.add(x);
    }
    
    public int pop() {
        int size = arr.size();
        if(size == 0) return -1;

        int num = arr.get(size - 1);
        arr.remove(size - 1);

        return num;
    }
    
    public void increment(int k, int val) {
        
        int len = arr.size();
        for(int i=0; i < k && i < len; i++){
            arr.set(i, arr.get(i) + val);
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */