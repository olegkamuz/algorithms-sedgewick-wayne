public class Matrix {
    public static void main(String[] args) {
        double[] x = {1, 2, 3, 4} ;
        double[] y = {7, 8, 9, 3};
        double[][] a ={{3,9,5,4},{8,3,4,2},{4,5,8,1}};
        double[][] b ={{6,7,9,8,6},{1,2,3,3,1},{3,7,6,7,1},{2,8,9,2,9}};
        showDot(dot(x, y));
        showMatrix(mult(a, b));
        showMatrix(transpose(a));
        showMatrix(mult(a, x));
        showMatrix(mult(x,a));
    }

    private static double[][] transpose(double[][] a){
        double[][] transposedArr = new double[a[0].length][a.length];
        for(int i = 0; i < transposedArr.length; i++) {
            for (int j = 0; j < transposedArr[0].length; j++) {
                transposedArr[i][j] = a[j][i];
            }
        }
        return transposedArr;
    }
    private static void showDot(double dot){
        System.out.println(dot);
        System.out.println();
    }
    private static void showMatrix(double[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%-6.1f",matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    private static void showMatrix(double[] matrix) {
        for(int i = 0; i < matrix.length; i++) {
                System.out.printf("%-6.1f",matrix[i]);
            System.out.println();
        }
        System.out.println();
    }
    private static double[][] mult(double[][] a, double[][] b){
        if (a == null || b == null || a.length == 0 || b.length == 0 || a[0].length != b.length) {
            throw new IllegalArgumentException();
        }
        double[][] newMatrix = new double[a.length][b[0].length];
        for (int k = 0; k < b[0].length; k++) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    newMatrix[i][k] += a[i][j] * b[j][k];
                }
            }
        }
        return newMatrix;
    }
    private static double[] mult(double[][] a, double[] x){
        if (a == null || x == null || a.length == 0 || x.length == 0 || a[0].length != x.length) {
            throw new IllegalArgumentException();
        }
        double[] newMatrix = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                newMatrix[i] += a[i][j] * x[j];
            }
        }
        return newMatrix;
    }
    private static double[] mult(double[] y, double[][] b){
        if (b == null || y == null || b.length == 0 || y.length == 0 || b[0].length != y.length) {
            throw new IllegalArgumentException();
        }
        double[] newMatrix = new double[b.length];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                newMatrix[i] += y[j] * b[i][j];
            }
        }
        return newMatrix;
    }
    private static double dot(double[] x, double[] y){
        if(x == null || y == null || x.length != y.length) {
            throw new IllegalArgumentException();
        }
        double sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += x[i] * y[i];
        }
        return sum;
    }
}
