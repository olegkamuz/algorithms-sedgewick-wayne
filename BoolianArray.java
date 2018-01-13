public class BooleanArray {
    public static void main(String args[]) {
        int n = 5;
        boolean[][] a = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                a[i][j] = isPrime(i, j);
            }
        }
    }
    private static int isPrime(int i, int j){
      if (j == 0) return i;
      int q = i % j;
      return isPrime(i, q);
    }
}
