public class Test {
    public static void main(String[] args) {
        int G = 0;
        System.out.println(++G);
        System.out.println(G);
    }

    private String[] a; // stack entries
    private int N;

    public Test(int cap) {
        a = new String[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(String item) {
        a[N++] = item;
    }

    public String pop() {
        return a[--N];
    }
}


