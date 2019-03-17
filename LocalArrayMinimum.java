import java.util.Arrays;

public class LocalArrayMinimum {
    boolean foundAtLeastOnce = false;
    int[] a;
    public LocalArrayMinimum (int[] a) {
        System.out.println("Local minimum of array: ");
        if (a.length == 0) printEmptyArray();
        else if (a.length < 3) printNoLocalMinimumsFound();
        else {
            this.a = a;
            printArray();
            if (!find()) printNoLocalMinimumsFound();
        }
    }
    private boolean find() {
        for (int i = 0; i < a.length - 2; i++) {
            if (a[i] > a[i + 1] && a[i + 1] < a[i + 2]) {
                foundAtLeastOnce = true;
                printLocalMinimum(i);
            }
        }
        return foundAtLeastOnce;
    }
    private void printLocalMinimum(int i) {
        System.out.println("a[" + (i + 1) + "] with value: " + (a[i + 1]));
    }
    private void printArray() {
        System.out.println(Arrays.toString(a));
    }
    private void printNoLocalMinimumsFound() {
        System.out.println("No local minimums found");
    }
    private void printEmptyArray() {
        System.out.println("Empty array");
    }
}

