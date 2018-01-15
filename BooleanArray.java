public class BooleanArray {
    public static void main(String args[]) {
        boolean res = isPrime(3,4);
        int n = 5;
        boolean[][] a = new boolean[n][n];
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < n; j++) {
                a[i][j] = isPrime(i, j);
            }
        }
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < n; j++) {
                System.out.printf("%1d:%1d:%-6b", i, j, a[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean isPrime(int i, int j) {
        int res = euclid(i, j);
        if (res == 1) return true;
        return false;
    }

    private static int euclid(int i, int j){
        if (j == 0) return i;
        int q = i % j;
        return euclid(j, q);
    }
}
