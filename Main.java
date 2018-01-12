public class Main {
    public static void main(String[] args) {
        int a = 33;
        int b = 24;
        int c = 15;
        ascend(a, b, c);
    }

    public static void ascend(int a, int b, int c) {
        int t;
        if (a > b) { t = a; a = b; b = t; }
        if (a > c) { t = a; a = c; c = t; }
        if (b > c) { t = b; b = c; c = t; }
        System.out.printf("a : %d, b : %d, c : %d", a, b, c);
    }
}

