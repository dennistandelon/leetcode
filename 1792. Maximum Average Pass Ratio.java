class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> priorityQueue = new PriorityQueue<>((a, b) -> {
            double improvementA = (a[0] + 1) / (a[1] + 1) - a[0] / a[1];
            double improvementB = (b[0] + 1) / (b[1] + 1) - b[0] / b[1];
            return Double.compare(improvementB, improvementA);
        });
      
        for (int[] cls : classes) {
            priorityQueue.offer(new double[] {cls[0], cls[1]});
        }
      
        while (extraStudents-- > 0) {
            double[] currentClass = priorityQueue.poll();
            double passes = currentClass[0] + 1, totalStudents = currentClass[1] + 1;
            priorityQueue.offer(new double[] {passes, totalStudents});
        }
      
        double totalAverageRatio = 0;
        while (!priorityQueue.isEmpty()) {
            double[] classRatio = priorityQueue.poll();
            totalAverageRatio += classRatio[0] / classRatio[1];
        }
      
        return totalAverageRatio / classes.length;
    }
}