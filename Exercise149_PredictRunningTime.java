public class Exercise149_PredictRuningTime {
    public void main (String[] args) {
        int N0 = 0;
        double T = 0;
        int N = 0;
        int b = 0;
        double predictRunningTime = predictRunningTime(N, N0, T, b);
        System.out.println("Predict running time for " + N + " elements is " + predictRunningTime + " seconds");

    }
    private double predictRunningTime(int N, int N0, double T, int b){
       return ((N/N0) - 1) * Math.pow(2,b) * T;
    }
}
