class MyCalendar {
    int[] starts;
    int[] ends;
    int count;    

    public MyCalendar() {
        starts = new int[10001];
        ends = new int[10001];
        count = 0;
    }
    
    public boolean book(int start, int end) {
        boolean isBooked = false;
        
        for(int i=0; i < count; i++){
            if(!(end <= starts[i] || start >= ends[i])){
                isBooked = true;
                break;
            } 
        }

        if(!isBooked){
            starts[count] = start;
            ends[count] = end;
            count++;
            return true;
        }

        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */