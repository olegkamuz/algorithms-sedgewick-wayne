public class Exercise1120_Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(14));
    }

    public static long factorial(int N) {
        if (N == 1) return 1;
        return N * factorial(N - 1);
    }
}
