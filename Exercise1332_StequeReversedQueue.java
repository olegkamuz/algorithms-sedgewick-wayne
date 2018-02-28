public class Exercise1332_StequeReversedQueue {
    public static void main(String[] args) {
        NonrecurringInt nonrecurringInt = new NonrecurringInt(1000);
        StequeReversedQueue<Integer> stequeReversedQueue = new StequeReversedQueue<>();

        // enqueue, push, pop all
        test1(stequeReversedQueue, nonrecurringInt);

        // push, enqueue, pop all
        test2(stequeReversedQueue, nonrecurringInt);

        // enqueue, push, enqueue, push, pop all
        test3(stequeReversedQueue, nonrecurringInt);
    }

    private static void test1(StequeReversedQueue<Integer> stequeReversedQueue, NonrecurringInt nonrecurringInt) {
        StdOut.println("test 1: ");
        StdOut.println();
        enqueueSteque(3, stequeReversedQueue, nonrecurringInt);
        pushSteque(3, stequeReversedQueue, nonrecurringInt);
        popSteque(8, stequeReversedQueue);
    }

    private static void test2(StequeReversedQueue<Integer> stequeReversedQueue, NonrecurringInt nonrecurringInt) {
        StdOut.println("test 2: ");
        StdOut.println();
        pushSteque(3, stequeReversedQueue, nonrecurringInt);
        enqueueSteque(3, stequeReversedQueue, nonrecurringInt);
        popSteque(8, stequeReversedQueue);
    }

    private static void test3(StequeReversedQueue<Integer> stequeReversedQueue, NonrecurringInt nonrecurringInt) {
        StdOut.println("test 3: ");
        StdOut.println();
        enqueueSteque(2, stequeReversedQueue, nonrecurringInt);
        pushSteque(2, stequeReversedQueue, nonrecurringInt);
        enqueueSteque(2, stequeReversedQueue, nonrecurringInt);
        pushSteque(2, stequeReversedQueue, nonrecurringInt);
        popSteque(15, stequeReversedQueue);
    }

    private static void enqueueSteque(int times, StequeReversedQueue<Integer> stequeReversedQueue, NonrecurringInt nonrecurringInt) {
        int nextInt;
        for (int i = 0; i < times; i++) {
            nextInt = nonrecurringInt.getInt();
            StdOut.println("StequeReversedQueue after ENQUEUE '" + nextInt + "' :");
            stequeReversedQueue.enqueue(nextInt);
            printSteque(stequeReversedQueue);
        }
    }

    private static void pushSteque(int times, StequeReversedQueue<Integer> stequeReversedQueue, NonrecurringInt nonrecurringInt) {
        int nextInt;
        for (int i = 0; i < times; i++) {
            nextInt = nonrecurringInt.getInt();
            StdOut.println("StequeReversedQueue after PUSH '" + nextInt + "' :");
            stequeReversedQueue.push(nextInt);
            printSteque(stequeReversedQueue);
        }
    }

    private static void popSteque(int times, StequeReversedQueue<Integer> stequeReversedQueue) {
        int poped;
        for (int i = 0; i < times; i++) {
            if (!stequeReversedQueue.isEmpty()) {
                poped = stequeReversedQueue.pop();
                StdOut.println("StequeReversedQueue after POP the '" + poped + "' :");
                printSteque(stequeReversedQueue);
            } else {
                StdOut.println("StequeReversedQueue is empty");
                StdOut.println();
            }
        }
    }

    private static void printSteque(StequeReversedQueue<Integer> stequeReversedQueue) {
        if (stequeReversedQueue.isEmpty()) {
            StdOut.println("StequeReversedQueue is empty");
        }
        for (Integer s : stequeReversedQueue) {
            StdOut.println(s);
        }
        StdOut.println();
    }

}
