public class Exercise1348_TwoStackDeque {
    public static void main(String[] args) {
        NonrecurringInt nonrecurringInt = new NonrecurringInt(100);
        Deque<Integer> deque = DequeDoubleLinked.Deque();
        StackDequeOne<Integer> stack1 = new StackDequeOne<>(deque);
        StackDequeTwo<Integer> stack2 = new StackDequeTwo<>(deque);

        StdOut.println("Test stack 1");
        testStackDeque(5, stack1, nonrecurringInt);

        StdOut.println("Test stack 2");
        testStackDeque(5, stack2, nonrecurringInt);

    }

    private static void testStackDeque(int times, StackDequeAPI<Integer> stackDeque, NonrecurringInt nonrecurringInt) {
        for (int i = 0; i < times; i++) {
            stackDeque.push(nonrecurringInt.getInt());
        }
        StdOut.println("stack pushed " + times + " times: ");
        StdOut.println("have size: " + stackDeque.size());
        StdOut.println("is empty: " + stackDeque.isEmpty());
        StdOut.println("poped " + times + " times: ");
        for (int i = 0; i < times; i++) {
            StdOut.print(stackDeque.pop() + " ");
        }
        StdOut.println();
        StdOut.println("have size: " + stackDeque.size());
        StdOut.println("is empty: " + stackDeque.isEmpty());
        StdOut.println();
    }
}
