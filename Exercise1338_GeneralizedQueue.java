public class Exercise1338_GeneralizedQueue {
    public static void main(String[] args) {
        GeneralizedQueue<Integer> generalizedQueue = GeneralizedQueue.<Integer>GeneralizedQueue();
        NonrecurringInt nonrecurringInt = new NonrecurringInt(100);

        generalizedQueue.insert(nonrecurringInt.getInt());
        generalizedQueue.insert(nonrecurringInt.getInt());
        generalizedQueue.insert(nonrecurringInt.getInt());
        generalizedQueue.insert(nonrecurringInt.getInt());
        generalizedQueue.insert(nonrecurringInt.getInt());
        generalizedQueue.insert(nonrecurringInt.getInt());

        print(generalizedQueue);

        generalizedQueue.delete(3);

        print(generalizedQueue);
    }
    private static void print(GeneralizedQueue<Integer> generalizedQueue) {
        for (Integer i: generalizedQueue) {
            StdOut.print(i + " ");
        }
        StdOut.println();
    }
}
