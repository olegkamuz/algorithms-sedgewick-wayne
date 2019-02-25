import java.util.Arrays;

public class TwoArraysEqualValueElements {
    private int[] a;
    private int[] b;
    private LinkedList<Integer> firstArrayEqualIndexes = new LinkedList<>();
    private LinkedList<Integer> secondArrayEqualIndexes = new LinkedList<>();
    public TwoArraysEqualValueElements (int[] a, int[] b) {
       this.a = a;
       this.b = b;
       System.out.println("First  array: " + Arrays.toString(a));
       System.out.println("Second array: " + Arrays.toString(b));
       System.out.println();
       findEqualElements();
    }
    private void print(LinkedList<Integer> arr) {
        for(Integer i: arr) {
            System.out.print(i + " ");
        }
    }
    private void findEqualElements () {
        LinkedList<Integer> firstArrayEqualIndexes = new LinkedList<>();
        LinkedList<Integer> secondArrayEqualIndexes = new LinkedList<>();
        int firstArrayIndex;
        int secondArrayIndex = 0;

        int lowestIndex = BinSearchMod.rank(b[secondArrayIndex], a);
        if (lowestIndex == -1) {
            secondArrayIndex++;
        } else {
            secondArrayEqualIndexes.add(secondArrayIndex);

            firstArrayIndex = lowestIndex;
            firstArrayEqualIndexes.add(firstArrayIndex++);
            while (b[secondArrayIndex] == a[firstArrayIndex]) {
                firstArrayEqualIndexes.add(firstArrayIndex++);
            }
            while (secondArrayIndex < b.length - 1 && a[firstArrayIndex-1] == b[secondArrayIndex + 1]) {
                secondArrayEqualIndexes.add(++secondArrayIndex);
            }
            System.out.println("Elements with same value: " + b[secondArrayIndex] + " \nappears in first array with indexes: ");
            print(firstArrayEqualIndexes);
            System.out.println("\nappears in second array with indexes: ");
            print(secondArrayEqualIndexes);
            System.out.print("\n\n");
        }
        firstArrayEqualIndexes.clear();
        secondArrayEqualIndexes.clear();
        if (secondArrayIndex < b.length - 1) {
            findEqualElements(++secondArrayIndex);
        }
    }
    private void findEqualElements (int secondArrayIndex) {

        int lowestIndex = BinSearchMod.rank(b[secondArrayIndex], a);
        int firstArrayIndex;
        if (lowestIndex == -1) {
            if (secondArrayIndex < b.length - 1) {
                findEqualElements(++secondArrayIndex);
            }
        } else {
            secondArrayEqualIndexes.add(secondArrayIndex);

            firstArrayIndex = lowestIndex;
            firstArrayEqualIndexes.add(firstArrayIndex++);
            while(firstArrayIndex <= a.length - 1 && b[secondArrayIndex] == a[firstArrayIndex]) {
                firstArrayEqualIndexes.add(firstArrayIndex);
                firstArrayIndex++;
            }
            while(secondArrayIndex < b.length - 1 && a[firstArrayIndex-1] == b[secondArrayIndex + 1]){
                secondArrayEqualIndexes.add(++secondArrayIndex);
            }

            System.out.println("Elements with same value: " + b[secondArrayIndex] + " \n appears in first array with indexes: ");
            print(firstArrayEqualIndexes);
            System.out.println("\n appears in second array with indexes: ");
            print(secondArrayEqualIndexes);
            System.out.println("\n\n");

            firstArrayEqualIndexes.clear();
            secondArrayEqualIndexes.clear();
            if (secondArrayIndex < b.length - 1) {
                findEqualElements(++secondArrayIndex);
            }
        }
   }
}
