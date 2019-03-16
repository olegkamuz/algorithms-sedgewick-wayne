import java.util.Arrays;

public class FarthestPair {
    private boolean firstTime = true;
    private double max = 0;
    private int firstIndex;
    private int secondIndex;
    private double[] a;
    public FarthestPair (double[] a) {
        if(a.length == 0) printEmptyArray();
        if(a.length == 1) printNeedAtLeastTwoElements();
        else {
            this.a = a;
            printArray();
            System.out.println();
            find();
        }
    }
    private void find() {
        if (a.length == 2) {
            firstIndex = 0;
            secondIndex = 1;
            double difference = 0;
            if ((a[0] < 0 && a[1] < 0) || (a[0] > 0 && a[1] > 0)) {
                difference = Math.abs(Math.abs(a[0]) - Math.abs(a[1]));
            }
            if ((a[0] < 0 && a[1] > 0) || (a[0] > 0 && a[1] < 0)) {
                difference = Math.abs(Math.abs(a[0]) + Math.abs(a[1]));
            }
            max = difference;
        } else {
            for (int i = 0; i < a.length - 2; i++) {
                if ((a[i] < 0 && a[i + 1] < 0) || (a[i] > 0 && a[i + 1] > 0)) {
                    double difference = Math.abs(Math.abs(a[i]) - Math.abs(a[i + 1]));
                    if (difference > max || firstTime) {
                        firstTime = false;
                        max = difference;
                        firstIndex = i;
                        secondIndex = i + 1;
                    }
                }
                if ((a[i] < 0 && a[i + 1] > 0) || (a[i] > 0 && a[i + 1] < 0)) {
                    double difference = Math.abs(Math.abs(a[i]) + Math.abs(a[i + 1]));
                    if (difference > max || firstTime) {
                        firstTime = false;
                        max = difference;
                        firstIndex = i;
                        secondIndex = i + 1;
                    }
                }
            }
        }
        printMinValueAndIndexes();
    }
    private void printNeedAtLeastTwoElements() {
        System.out.println("Need at least two elements");
    }
    private void printEmptyArray() {
        System.out.println("Empty array");
    }
    private void printMinValueAndIndexes() {
        System.out.println("Closest pair is between a[" + firstIndex + "] and a[" + secondIndex + "] with distance: " + max);
    }
    private void printArray() {
        System.out.println(Arrays.toString(a));
    }
}
