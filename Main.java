public class Main {
    public static long[] F(int N) {
        long[] FibRow = new long[N];
        FibRow[0] = 0;
        if(N == 0) return FibRow;
        FibRow[1] = 1;
        if(N == 1) return FibRow;
        for (int i = 2; i < N; i++) {
            FibRow[i] = FibRow[i-1] + FibRow[i-2];
        }
        return FibRow;
    }

    public static void main(String[] args) {
        int N = 100;
        long[] arr = F(N);
        for (int i = 0; i < N; i++) {
            StdOut.println(i + " : " +arr[i]);
        }
    }
}
