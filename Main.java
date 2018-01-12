public class Main {
    public static void main(String[] args) {
        int indent = 6;
        Euclid(1111111, 1234567, indent);
    }

    public static int Euclid(int p, int q, int indent) {
        indent += 2;
        System.out.printf("%" + indent + "d%9d", p, q);
        System.out.println();
        if (q == 0) {
            System.out.printf("%1d", p);
            return p;
        }
        int r = p % q;
        return Euclid(q, r, indent);
    }
}

