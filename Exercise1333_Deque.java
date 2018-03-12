public class Exercise1333_Deque {
    public static void main(String[] args) {

        NonrecurringInt nonrecurringInt = new NonrecurringInt(1000);

        Deque<Integer> dequeDoubleLinked = DequeDoubleLinked.Deque();

        Deque<Integer> resizingArrayDeque = ResizingArrayDeque.Deque();

        testDoubleLinkedImplementation(dequeDoubleLinked, nonrecurringInt);

        testResizingArrayImplementation(resizingArrayDeque, nonrecurringInt);

    }

    private static void testDoubleLinkedImplementation(Deque<Integer> dequeDoubleLinked, NonrecurringInt nonrecurringInt) {
        StdOut.println();
        StdOut.println("Double linked deque tests: ");
        // push right, push left, pop left all
        test1(dequeDoubleLinked, nonrecurringInt);

        // push left, push right, pop right all
        test2(dequeDoubleLinked, nonrecurringInt);

        // push left, push right, (pop left, pop right) till the end
        test3(dequeDoubleLinked, nonrecurringInt);

        // (push left, push right) x 2, (pop left, pop right) till the end
        test4(dequeDoubleLinked, nonrecurringInt);
    }

    private static void testResizingArrayImplementation(Deque<Integer> resizingArrayDeque, NonrecurringInt nonrecurringInt) {
        StdOut.println();
        StdOut.println("Resizing array deque tests: ");
        // push right, push left, pop left all
        test1(resizingArrayDeque, nonrecurringInt);

        // push left, push right, pop right all
        test2(resizingArrayDeque, nonrecurringInt);

        // push left, push right, (pop left, pop right) till the end
        test3(resizingArrayDeque, nonrecurringInt);

        // (push left, push right) x 2, (pop left, pop right) till the end
        test4(resizingArrayDeque, nonrecurringInt);
    }

    private static void test1(Deque<Integer> dequeDoubleLinked, NonrecurringInt nonrecurringInt) {
        StdOut.println();
        StdOut.println("test 1: ");
        StdOut.println();
        pushDequeRight(3, dequeDoubleLinked, nonrecurringInt);
        pushDequeLeft(3, dequeDoubleLinked, nonrecurringInt);
        popDequeLeft(8, dequeDoubleLinked);
    }

    private static void test2(Deque<Integer> dequeDoubleLinked, NonrecurringInt nonrecurringInt) {
        StdOut.println();
        StdOut.println("test 2: ");
        StdOut.println();
        pushDequeLeft(3, dequeDoubleLinked, nonrecurringInt);
        pushDequeRight(3, dequeDoubleLinked, nonrecurringInt);
        popDequeRight(8, dequeDoubleLinked);
    }

    private static void test3(Deque<Integer> dequeDoubleLinked, NonrecurringInt nonrecurringInt) {
        StdOut.println();
        StdOut.println("test 3: ");
        StdOut.println();
        pushDequeLeft(5, dequeDoubleLinked, nonrecurringInt);
        pushDequeRight(5, dequeDoubleLinked, nonrecurringInt);
        popDequeLeft(2, dequeDoubleLinked);
        popDequeRight(2, dequeDoubleLinked);
        popDequeLeft(2, dequeDoubleLinked);
        popDequeRight(2, dequeDoubleLinked);
        popDequeLeft(2, dequeDoubleLinked);
        popDequeRight(2, dequeDoubleLinked);
    }

    private static void test4(Deque<Integer> dequeDoubleLinked, NonrecurringInt nonrecurringInt) {
        StdOut.println();
        StdOut.println("test 4: ");
        StdOut.println();
        pushDequeLeft(5, dequeDoubleLinked, nonrecurringInt);
        pushDequeRight(5, dequeDoubleLinked, nonrecurringInt);
        pushDequeLeft(5, dequeDoubleLinked, nonrecurringInt);
        pushDequeRight(5, dequeDoubleLinked, nonrecurringInt);
        popDequeLeft(3, dequeDoubleLinked);
        popDequeRight(3, dequeDoubleLinked);
        popDequeLeft(3, dequeDoubleLinked);
        popDequeRight(3, dequeDoubleLinked);
        popDequeLeft(3, dequeDoubleLinked);
        popDequeRight(3, dequeDoubleLinked);
        popDequeLeft(3, dequeDoubleLinked);
        popDequeRight(3, dequeDoubleLinked);
    }
    private static void pushDequeRight(int times, Deque<Integer> dequeDoubleLinked, NonrecurringInt nonrecurringInt) {
        int nextInt;
        for (int i = 0; i < times; i++) {
            nextInt = nonrecurringInt.getInt();
            StdOut.println("Deque PUSH RIGHT '" + nextInt + "' :");
            dequeDoubleLinked.pushRight(nextInt);
            printDeque(dequeDoubleLinked);
        }
    }

    private static void pushDequeLeft(int times, Deque<Integer> dequeDoubleLinked, NonrecurringInt nonrecurringInt) {
        int nextInt;
        for (int i = 0; i < times; i++) {
            nextInt = nonrecurringInt.getInt();
            StdOut.println("Deque after PUSH LEFT '" + nextInt + "' :");
            dequeDoubleLinked.pushLeft(nextInt);
            printDeque(dequeDoubleLinked);
        }
    }

    private static void popDequeLeft(int times, Deque<Integer> dequeDoubleLinked) {
        int poped;
        for (int i = 0; i < times; i++) {
            if (!dequeDoubleLinked.isEmpty()) {
                poped = dequeDoubleLinked.popLeft();
                StdOut.println("Deque after POP LEFT the '" + poped + "' :");
                printDeque(dequeDoubleLinked);
            } else {
                StdOut.println("Deque is empty");
                StdOut.println();
            }
        }
    }

    private static void popDequeRight(int times, Deque<Integer> dequeDoubleLinked) {
        int poped;
        for (int i = 0; i < times; i++) {
            if (!dequeDoubleLinked.isEmpty()) {
                poped = dequeDoubleLinked.popRight();
                StdOut.println("Deque after POP RIGHT the '" + poped + "' :");
                printDeque(dequeDoubleLinked);
            } else {
                StdOut.println("Deque is empty");
                StdOut.println();
            }
        }
    }

    private static void printDeque(Deque<Integer> dequeDoubleLinked) {
        if (dequeDoubleLinked.isEmpty()) {
            StdOut.println("Deque is empty");
        }
        for (Integer s : dequeDoubleLinked) {
            StdOut.print(s + " ");
        }
        StdOut.println();
    }

}

