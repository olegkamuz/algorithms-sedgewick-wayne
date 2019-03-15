import java.util.Arrays;

public class TwoSumFaster {
    private int[] a;
    public TwoSumFaster(int[] a) {
        System.out.println("Two sums: ");
        if (a.length == 0) printEmptyArray();
        else {
            this.a = a;
            printArray();
            System.out.println();
            if (!find()) printNoSumsFound();
        }
        System.out.println();
    }
    private boolean find() {
        int i = 0; // most left(first) index
        int j = a.length - 1; // most right (last) index
        boolean foundAtLeastOnce = false;
        while (i < a.length - 1 && j > 0 && i != j) {
            if (a[i] < 0 && a[j] > 0) { // "mirrored" elements values with pivot on zero valued element
                if (Math.abs(a[i]) == a[j]) {
                    printSumIndexes(i, j);
                    foundAtLeastOnce = true;
                    i++;
                    j--;
                } else if (Math.abs(a[i]) > Math.abs(a[j])) {
                    i++;
                } else if (Math.abs(a[i]) < Math.abs(a[j])) {
                    j--;
                }
            } else { // both elements values on one side of zero or one elements value is zero, so zero sum is impossible
                return foundAtLeastOnce;
            }
        }
        return foundAtLeastOnce;
    }

    private void printSumIndexes(int i, int j) {
        System.out.println("a[" + i + "] + a[" + j + "] = " + a[i] + " + " + a[j] + " = 0");
    }
    private void printNoSumsFound() {
        System.out.println("No sums found");
    }
    private void printEmptyArray() {
        System.out.println("Empty array");
    }
    private void printArray() {
        System.out.println(Arrays.toString(a));
    }
}
