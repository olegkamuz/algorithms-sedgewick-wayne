public class Exercise1218_VarianceForAccumulator {
    private double m;
    private double s;
    private int N;
    public void addDataValue(double x)
    {
        N++;
        s = s + 1.0 * (N-1) / N * (x - m) * (x - m);
        m = m + (x - m) / N;
    }
    public double mean()
    { return m; }
    public double var()
    { return s/(N - 1);
    }
    public double stddev()
    { return Math.sqrt(this.var());
    }
    public static void main(String[] args){
        Exercise1218_VarianceForAccumulator varAcc = new Exercise1218_VarianceForAccumulator();
        varAcc.addDataValue(1.0);
        varAcc.addDataValue(4.0);
//        varAcc.addDataValue(3.0);
//        varAcc.addDataValue(7.0);
//        varAcc.addDataValue(3.0);
//        varAcc.addDataValue(2.0);
//        varAcc.addDataValue(3.0);
//        varAcc.addDataValue(5.0);
//        varAcc.addDataValue(4.0);
//        varAcc.addDataValue(2.0);
        System.out.printf("mean: %1f variance: %1f", varAcc.mean(), varAcc.var());
    }
}
