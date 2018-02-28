public class Exercise1333_Deque {
    public static void main(String[] args) {
        NonrecurringInt nonrecurringInt = new NonrecurringInt(1000);
        Deque<Integer> deque = Deque.Deque();

        // push right, push left, pop left all
        test1(deque, nonrecurringInt);

        // push left, push right, pop right all
        test2(deque, nonrecurringInt);

        // push left, push right, (pop left, pop right) till the end
        test3(deque, nonrecurringInt);

        // (push left, push right) x 2, (pop left, pop right) till the end
        test4(deque, nonrecurringInt);
    }

    private static void test1(Deque deque, NonrecurringInt nonrecurringInt) {
        StdOut.println("test 1: ");
        StdOut.println();
        pushDequeRight(3, deque, nonrecurringInt);
        pushDequeLeft(3, deque, nonrecurringInt);
        popDequeLeft(8, deque);
    }

    private static void test2(Deque deque, NonrecurringInt nonrecurringInt) {
        StdOut.println("test 2: ");
        StdOut.println();
        pushDequeLeft(3, deque, nonrecurringInt);
        pushDequeRight(3, deque, nonrecurringInt);
        popDequeRight(8, deque);
    }

    private static void test3(Deque deque, NonrecurringInt nonrecurringInt) {
        StdOut.println("test 3: ");
        StdOut.println();
        pushDequeLeft(5, deque, nonrecurringInt);
        pushDequeRight(5, deque, nonrecurringInt);
        popDequeLeft(2, deque);
        popDequeRight(2, deque);
        popDequeLeft(2, deque);
        popDequeRight(2, deque);
        popDequeLeft(2, deque);
        popDequeRight(2, deque);
    }

    private static void test4(Deque deque, NonrecurringInt nonrecurringInt) {
        StdOut.println("test 4: ");
        StdOut.println();
        pushDequeLeft(5, deque, nonrecurringInt);
        pushDequeRight(5, deque, nonrecurringInt);
        pushDequeLeft(5, deque, nonrecurringInt);
        pushDequeRight(5, deque, nonrecurringInt);
        popDequeLeft(3, deque);
        popDequeRight(3, deque);
        popDequeLeft(3, deque);
        popDequeRight(3, deque);
        popDequeLeft(3, deque);
        popDequeRight(3, deque);
        popDequeLeft(3, deque);
        popDequeRight(3, deque);
    }
    private static void pushDequeRight(int times, Deque<Integer> deque, NonrecurringInt nonrecurringInt) {
        int nextInt;
        for (int i = 0; i < times; i++) {
            nextInt = nonrecurringInt.getInt();
            StdOut.println("Deque after PUSH RIGHT '" + nextInt + "' :");
            deque.pushRight(nextInt);
            printDeque(deque);
        }
    }

    private static void pushDequeLeft(int times, Deque<Integer> deque, NonrecurringInt nonrecurringInt) {
        int nextInt;
        for (int i = 0; i < times; i++) {
            nextInt = nonrecurringInt.getInt();
            StdOut.println("Deque after PUSH LEFT '" + nextInt + "' :");
            deque.pushLeft(nextInt);
            printDeque(deque);
        }
    }

    private static void popDequeLeft(int times, Deque<Integer> deque) {
        int poped;
        for (int i = 0; i < times; i++) {
            if (!deque.isEmpty()) {
                poped = deque.popLeft();
                StdOut.println("Deque after POP LEFT the '" + poped + "' :");
                printDeque(deque);
            } else {
                StdOut.println("Deque is empty");
                StdOut.println();
            }
        }
    }

    private static void popDequeRight(int times, Deque<Integer> deque) {
        int poped;
        for (int i = 0; i < times; i++) {
            if (!deque.isEmpty()) {
                poped = deque.popRight();
                StdOut.println("Deque after POP RIGHT the '" + poped + "' :");
                printDeque(deque);
            } else {
                StdOut.println("Deque is empty");
                StdOut.println();
            }
        }
    }

    private static void printDeque(Deque<Integer> deque) {
        if (deque.isEmpty()) {
            StdOut.println("Deque is empty");
        }
        for (Integer s : deque) {
            StdOut.println(s);
        }
        StdOut.println();
    }

}

