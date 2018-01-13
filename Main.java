public class Main {
    public static void main(String[] args) {
        int N = 5;
        int k = 0;
        System.out.println(binomial(N, k, .25));
    }

    public static double binomial(int N, int k, double p) {
        if (N == 0 && k == 0) return 1.0;
        if (N < 0 || k < 0) return 0.0;
        return (1.0 - p)*binomial(N-1, k, p) + p*binomial(N-1, k-1, p);
    }
}

