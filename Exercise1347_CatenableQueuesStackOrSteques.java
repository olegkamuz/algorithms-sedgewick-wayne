public class Exercise1347_CatenableQueuesStackOrSteques {
    public static void main(String[] args) {
        NonrecurringInt nonrecurringInt = new NonrecurringInt(100);
        CatenableClass<Integer> catenableClass = new CatenableClass<>();
        testStackConcatination(catenableClass, nonrecurringInt);
        testQueueConcationation(catenableClass, nonrecurringInt);
        testStequeueConcatination(catenableClass, nonrecurringInt);
    }
    private static void testQueueConcationation(CatenableClass<Integer> catenableClass, NonrecurringInt nonrecurringInt) {
        int times = 5;
        StdOut.println("Test queue Concatenation:");
        Queue<Integer> queue1 = new Queue<>();
        fillIn(5, queue1, nonrecurringInt);
        StdOut.println("queue enqueued " + times + " times");
        StdOut.println(queue1);
        Queue<Integer> queue2 = new Queue<>();
        fillIn(5, queue2, nonrecurringInt);
        StdOut.println("queue enqueued " + times + " times");
        StdOut.println(queue2);
        StdOut.println("result: ");
        StdOut.println(catenableClass.catenation(queue1, queue2).toString());
        StdOut.println();
    }
    private static void testStackConcatination(CatenableClass<Integer> catenableClass, NonrecurringInt nonrecurringInt) {
        int times = 5;
        StdOut.println("Test stack Concatenation:");
        Stack<Integer> stack1 = new Stack<>();
        fillIn(5, stack1, nonrecurringInt);
        StdOut.println("stack pushed " + times + " times");
        StdOut.println(stack1);
        StdOut.println("concatenated with: ");
        Stack<Integer> stack2 = new Stack<>();
        fillIn(5, stack2, nonrecurringInt);
        StdOut.println("stack pushed " + times + " times");
        StdOut.println(stack2);
        StdOut.println("result: ");
        StdOut.println(catenableClass.catenation(stack1, stack2).toString());
        StdOut.println();
    }
    private static void testStequeueConcatination(CatenableClass<Integer> catenableClass, NonrecurringInt nonrecurringInt) {
        int times = 5;
        StdOut.println("Test steque concatenation:");
        StdOut.println("steque pushed " + times + " times, than enqueue " + times + " times");
        Steque<Integer> steque1 = new Steque<>();
        fillIn(times, steque1, nonrecurringInt);
        StdOut.println(steque1);
        StdOut.println("concatinated with: ");
        StdOut.println("steque pushed " + times + " times, than enqueue " + times + " times");
        Steque<Integer> steque2 = new Steque<>();
        fillIn(times, steque2, nonrecurringInt);
        StdOut.println(steque2);
        StdOut.println("result: ");
        StdOut.println(catenableClass.catenation(steque1, steque2));
        StdOut.println();
    }
    private static void fillIn(int times, Stack<Integer> stack, NonrecurringInt nonrecurringInt) {
        for (int i = 0; i < times; i++) {
            stack.push(nonrecurringInt.getInt());
        }
    }
    private static void fillIn(int times, Queue<Integer> queue, NonrecurringInt nonrecurringInt) {
        for (int i = 0; i < times; i++) {
            queue.enqueue(nonrecurringInt.getInt());
        }
    }
    private static void fillIn(int times, Steque<Integer> steque, NonrecurringInt nonrecurringInt) {
        for (int i = 0; i < times; i++) {
            steque.push(nonrecurringInt.getInt());
        }
        for (int i = 0; i < times; i++) {
            steque.enqueue(nonrecurringInt.getInt());
        }
    }
}
