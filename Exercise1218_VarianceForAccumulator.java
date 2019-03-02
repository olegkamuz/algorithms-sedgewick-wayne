public class Exercise1218_VarianceForAccumulator {
    public static void main(String[] args){
        Accumulator accumulator = new Accumulator();
        accumulator.addDataValue(1.0);
        accumulator.addDataValue(4.0);
//        varAcc.addDataValue(3.0);
//        varAcc.addDataValue(7.0);
//        varAcc.addDataValue(3.0);
//        varAcc.addDataValue(2.0);
//        varAcc.addDataValue(3.0);
//        varAcc.addDataValue(5.0);
//        varAcc.addDataValue(4.0);
//        varAcc.addDataValue(2.0);
        System.out.printf("mean: %1f variance: %1f", accumulator.mean(), accumulator.var());
    }
}
