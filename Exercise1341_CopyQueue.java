public class Exercise1341_CopyQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        NonrecurringInt nonrecurringInt = new NonrecurringInt(100);
        makeQueue(5, q, nonrecurringInt); // 1 2 3 4 5
        StdOut.println();
        StdOut.println("Original queue, expected: \n1 2 3 4 5");
        print(q);

        Queue<Integer> r = new Queue<>(q);
        StdOut.println("Copied queue expected: \n1 2 3 4 5");
        print(r);

        r.enqueue(nonrecurringInt.getInt()); // 6
        r.enqueue(nonrecurringInt.getInt()); // 7

        q.dequeue(); // 1
        q.enqueue(nonrecurringInt.getInt()); // 8

        r.dequeue(); // 1

        StdOut.println("Copied queue expected: \n2 3 4 5 6 7");
        print(r);

        StdOut.println("Original queue expected: \n2 3 4 5 8");
        print(q);
    }

    private static void print(Queue<Integer> r) {
        for (Integer i: r) {
            StdOut.print(i + " ");
        }
        StdOut.println();
        StdOut.println();
    }

    private static void makeQueue(int times, Queue<Integer> q, NonrecurringInt nonrecurringInt) {
        for (int i = 0; i < times; i++) {
            q.enqueue(nonrecurringInt.getInt());
        }
    }
}
