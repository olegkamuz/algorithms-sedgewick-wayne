public class Exercise1342_CopyStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        NonrecurringInt nonrecurringInt = new NonrecurringInt(100);
        makeStack(5, s, nonrecurringInt);
        StdOut.println();
        StdOut.println("Original stack, expected: \n5 4 3 2 1 ");
        print(s);

        Stack<Integer> t = new Stack<>(s);
        StdOut.println("Copy stack, expected: \n5 4 3 2 1");
        print(t);

        t.pop(); // 5
        t.push(nonrecurringInt.getInt()); // 6
        t.push(nonrecurringInt.getInt()); // 7

        s.pop(); // 5
        s.push(nonrecurringInt.getInt()); // 8

        StdOut.println("Original stack, expected: \n8 4 3 2 1 ");
        print(s);


        StdOut.println("Copy stack, expected: \n7 6 4 3 2 1 ");
        print(t);
    }

    private static void print(Stack<Integer> s) {
        for (Integer i: s) {
            StdOut.print(i + " ");
        }
        StdOut.println();
    }

    private static void makeStack(int times, Stack<Integer> s, NonrecurringInt nonrecurringInt) {
        for (int i = 0; i < times; i++) {
            s.push(nonrecurringInt.getInt());
        }
    }

}
