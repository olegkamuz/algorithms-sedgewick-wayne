/**
 * Check for clarification on Wiki pages
 * https://github.com/olegkamuz/algorithms-sedgewick-wayne/wiki/Exercise1349_QueueWithStacks-clarification
 *
 * Based on Rene Argento implementation of 6 stacks implementation from here http://stackoverflow.com/questions/5538192/how-to-implement-a-queue-with-three-stacks/
 * additional info: Real Time Queue Operations in Pure LISP
 */

public class Exercise1349_QueueWithStacks{

    public static void main(String[] args) {

       QueueWithStacks<Integer> queueWithStacks = new QueueWithStacks<>();
        NonrecurringInt nonrecurringInt = new NonrecurringInt(100);
        // queue, deque each with chosen times
        test1(22, queueWithStacks, nonrecurringInt);
        // (queue, deque) x 3 each with chosen times
        test2(2, queueWithStacks, nonrecurringInt);
    }
    private static void test1(int times, QueueWithStacks<Integer> queueWithStacks, NonrecurringInt nonrecurringInt) {
        StdOut.println();
        StdOut.println("queue, deque each with chosen times: ");
        for (int i = 0; i < times; i++) {
            queueWithStacks.enqueue(nonrecurringInt.getInt());
        }

        for (int i = 0; i < times; i++) {
            StdOut.print(queueWithStacks.dequeue() + " ");
        }
    }
    private static void test2(int times, QueueWithStacks<Integer> queueWithStacks, NonrecurringInt nonrecurringInt) {
        StdOut.println();
        StdOut.println("(queue, deque) x 3, each with chosen times: ");
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < times; i++) {
                queueWithStacks.enqueue(nonrecurringInt.getInt());
            }

            for (int i = 0; i < times; i++) {
                StdOut.print(queueWithStacks.dequeue() + " ");
            }
        }

    }

}
