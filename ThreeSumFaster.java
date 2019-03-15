import java.util.Arrays;

public class ThreeSumFaster {
    // Maid idea: all possible pairs to the right from zero compare with each one to the left from zero and vice versa - pairs from left cmp to the right single value
    // Make two arrays one with all possible pairs to the right from zero, other with all possible pairs to the left then pass this arrays as constructor argument to TwoSumFaster, get all three sums and get running time 2N, so its ~N(linear)
    // consider (n - 1) < n < (n + 1) so, according to transitive relation n < (n - 1) + (n + 1), n < (n - 2) + (n + 1) and so on

    private int[] a;
    public ThreeSumFaster(int[] a) {
        System.out.println("Three sums: ");
        if (a.length == 0) printEmptyArray();
        else {
            this.a = a;
            printArray();
            System.out.println();
            if (!find()) printNoSumsFound();
        }
    }
    private boolean find() {
        int j;
        int k = 0;
        int m = a.length - 1;
        boolean foundAtLeastOnce = false;
        for (int i = a.length - 1; i > 0 && a[i] > 0 && a[k] < 0; i--) {
            j = i - 1;
            while (a[j] > 0 && a[k] < 0) {
                if (a[j] + a[i] == Math.abs(a[k])) {
                    printSumIndexes(i, j, k);
                    foundAtLeastOnce = true;
                    i--;
                }
                else if (a[j] + a[i] > Math.abs(a[k])) j--;
                else if (a[j] + a[i] < Math.abs(a[k])) k++;
            }
        }
        for (int i = 0; i < a.length -1 && a[i] < 0 && a[m] > 0; i++) {
            j = i + 1;
            while (a[j] < 0 && a[m] > 0) {
                if (Math.abs(a[j] + a[i]) == a[m]) {
                    printSumIndexes(i, j, m);
                    foundAtLeastOnce = true;
                    i++;
                }
                else if (Math.abs(a[j] + a[i]) < a[m]) m--;
                else if (Math.abs(a[j] + a[i]) > a[m]) j++;
            }
        }
        return foundAtLeastOnce;
    }
    private void printSumIndexes(int i, int j, int k) {
        System.out.println("a[" + i + "] + a[" + j + "] + a[" + k + "] = " + a[i] + " + " + a[j] + " + " + a[k] + " = 0");
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
