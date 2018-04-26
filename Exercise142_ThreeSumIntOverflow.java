import java.math.BigInteger;

public class Exercise142_ThreeSumIntOverflow {
    private static int count(int[] a) {
        int count = 0;
        int length = a.length;

        BigInteger bigInteger;

        for (int i = 0; i < length; i++){
            for (int j = i + 1; j < length; j++){
                for (int k = j + 1; k < length; k++){
                    bigInteger = BigInteger.valueOf(a[i]);
                    bigInteger = bigInteger.add(BigInteger.valueOf(a[j]));
                    bigInteger = bigInteger.add(BigInteger.valueOf(a[k]));
                    if(bigInteger.intValue() == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        StdOut.println(count(a));
    }
}
