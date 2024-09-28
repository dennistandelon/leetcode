class MyCircularDeque {
    ArrayList<Integer> database;
    int max;
    public MyCircularDeque(int k) {
        database = new ArrayList<Integer>();
        max = k;
    }
    
    public boolean insertFront(int value) {
        if(!this.isFull()){
            this.database.add(0, value);
            return true;
        }

        return false;
    }
    
    public boolean insertLast(int value) {
        if(!this.isFull()){
            this.database.add(value);
            return true;
        }

        return false;
    }
    
    public boolean deleteFront() {
        if(!this.isEmpty()){
            this.database.remove(0);
            return true;
        }

        return false;
    }
    
    public boolean deleteLast() {
        if(!this.isEmpty()){
            this.database.remove(this.database.size() - 1);
            return true;
        }

        return false;
    }
    
    public int getFront() {
        if(!this.isEmpty()){
            return this.database.get(0);
        }

        return -1;
    }
    
    public int getRear() {
        if(!this.isEmpty()){
            return this.database.get(this.database.size() - 1);
        }

        return -1;
    }
    
    public boolean isEmpty() {
        if(database.size() == 0){
            return true;
        }

        return false;
    }
    
    public boolean isFull() {
        if(database.size() >= max){
            return true;
        }

        return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */