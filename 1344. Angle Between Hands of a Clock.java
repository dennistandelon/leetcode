class Solution {
    public double angleClock(int hour, int minutes) {
        
        double minuteX = minutes / 5.0; 
        double hourX = hour + (minutes/60.0);

        double degree1 = Math.min(Math.abs(hourX-minuteX), Math.abs(hourX - minuteX - 12));

        double degree2 = Math.min(Math.abs(minuteX - hourX), Math.abs(minuteX - (hourX + 12)));

        return Math.min(degree1,degree2) * 30;

    }
}