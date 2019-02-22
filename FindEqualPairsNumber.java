import java.util.Arrays;

public class FindEqualPairsNumber {
    public static void FindEqualPairsNumber(int[] a) {
        // we have to use combination formula: n!/(n-k)!k! (binomial coefficient)(let`s assume permutation in pair is unnecessary) with n = number of array elements with equal value and k = 2 (we search for pairs)
        System.out.println(Arrays.toString(a));
        int count = 0;
        int compared;
        boolean noEqualPairsFound = true;
        boolean firstInRow = true;
        for (int i = 1; i < a.length; i++) {
            compared = a[i];
            if (compared == a[i - 1]) {
                if (firstInRow) {
                    count = 1;
                }
                count++;
                firstInRow = false;
            }
            if (i + 1 <= a.length - 1 && compared != a[i + 1] && count > 0) {
                noEqualPairsFound = false;
                long pairsNumber = Factorial.factorial(count) / (Factorial.factorial(count - 2) * 2);
                System.out.println("Number of pairs with value " + compared + " is " + pairsNumber);
                count = 0;
                firstInRow = true;
            }
            if (i == a.length - 1 && noEqualPairsFound) {
               System.out.println("No pairs with same value found");
            }
        }
    }














}
