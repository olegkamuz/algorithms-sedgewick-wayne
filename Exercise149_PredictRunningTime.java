import static java.lang.Math.log;

public class Exercise149_PredictRunningTime {
    public void main (String[] args) {
        int N0 = 0;
        double T = 0;
        int N = 0;
        int b = 0;
        double predictRunningTime = predictRunningTime(N, T, b);
        System.out.println("Predict running time for " + N + " elements is " + predictRunningTime + " seconds");

    }
    private double predictRunningTime(int N, double T, int b){
//     time(N) = time(N0) * 2^b^lgN
       return T * Math.pow(Math.pow(2,b),log(N));
    }
}
