class MyCalendarTwo {
    int[] starts;
    int[] ends;
    int[] bookedStarts;
    int[] bookedEnds;
    int count;
    int bookedCount;

    public MyCalendarTwo() {
        starts = new int[1001];
        ends = new int[1001];
        bookedStarts = new int[1001];
        bookedEnds = new int[1001];
        count = 0;
        bookedCount = 0;
    }
    
    public boolean book(int start, int end) {
        boolean isBooked = false;

        for(int i=0; i < bookedCount; i++){
            if(end > bookedStarts[i] && start < bookedEnds[i]){
                return false;
            }
        }

        for(int i=0; i < count; i++){
            if(end > starts[i] && start < ends[i]){
                bookedStarts[bookedCount] = Math.max(start,starts[i]);
                bookedEnds[bookedCount] = Math.min(end,ends[i]);
                bookedCount++;
            }
        }

        starts[count] = start;
        ends[count] = end;
        count++;

        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */