public class Exercise1338_GeneralizedQueue {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        GeneralizedQueue<Integer> generalizedQueueArray = GeneralizedQueueArray.<Integer>GeneralizedQueue();
        GeneralizedQueue<Integer> generalizedQueueList = GeneralisedQueueList.<Integer>GeneralizedQueue();
        NonrecurringInt nonrecurringInt = new NonrecurringInt(100);

        testArrayImplementation(generalizedQueueArray, nonrecurringInt);

        testListImplementation(generalizedQueueList, nonrecurringInt);
    }

    private static void testArrayImplementation(GeneralizedQueue<Integer> generalizedQueueArray, NonrecurringInt nonrecurringInt) {
        StdOut.println();
        StdOut.println("Test Array Implementation: ");
        insert(6, generalizedQueueArray, nonrecurringInt);
        delete(3, 8, generalizedQueueArray);
        insert(6, generalizedQueueArray, nonrecurringInt);
        delete(3, 8, generalizedQueueArray);
    }

    private static void testListImplementation(GeneralizedQueue<Integer> generalisedQueueList, NonrecurringInt nonrecurringInt) {
        StdOut.println();
        StdOut.println("Test List Implementation: ");
        insert(6, generalisedQueueList, nonrecurringInt);
        delete(3,8, generalisedQueueList);
        insert(6, generalisedQueueList, nonrecurringInt);
        delete(3,8, generalisedQueueList);
    }

    private static void insert(int times, GeneralizedQueue<Integer> generalizedQueue, NonrecurringInt nonrecurringInt) {
        StdOut.println();
        StdOut.println(times + " elements inserted: ");
        for (int i = 0; i < times; i++) {
            generalizedQueue.insert(nonrecurringInt.getInt());
        }
        print(generalizedQueue);
        StdOut.println();
    }

    private static void delete(int k, int times, GeneralizedQueue<Integer> generalizedQueueArray) {
        StdOut.println(k + "-th element deleted, " + times + " times: ");
        for (int i = 0; i < times; i++) {
            if (generalizedQueueArray.delete(3) == null) StdOut.println("No such element");
            else print(generalizedQueueArray);
        }
        StdOut.println();
    }

    private static void print(GeneralizedQueue<Integer> generalizedQueue) {
        for (Integer i : generalizedQueue) {
            StdOut.print(i + " ");
        }
        StdOut.println();
    }
}
