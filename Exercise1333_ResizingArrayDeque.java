public class Exercise1333_ResizingArrayDeque {
    public static void main(String[] args) {
        ResizingArrayDeque<Integer> resizingArrayDeque = ResizingArrayDeque.Deque(1, 1);
        NonrecurringInt nonrecurringInt = new NonrecurringInt(1000);
        // push right, push left, pop left
        test1(resizingArrayDeque, nonrecurringInt);
        // push left, push right, pop right
        test2(resizingArrayDeque, nonrecurringInt);
        // (push right, push left, pop left, pop right) * 2
        test3(resizingArrayDeque, nonrecurringInt);
    }

    private static void test1(ResizingArrayDeque<Integer> resizingArrayDeque, NonrecurringInt nonrecurringInt) {
        StdOut.println("Test 1: ");
        pushRightDeque(5, resizingArrayDeque, nonrecurringInt);
        pushLeftDeque(5, resizingArrayDeque, nonrecurringInt);
        popLeftDeque(14, resizingArrayDeque);
    }

    private static void test2(ResizingArrayDeque<Integer> resizingArrayDeque, NonrecurringInt nonrecurringInt) {
        StdOut.println("Test 2: ");
        pushLeftDeque(5, resizingArrayDeque, nonrecurringInt);
        pushRightDeque(5, resizingArrayDeque, nonrecurringInt);
        popRightDeque(14, resizingArrayDeque);
    }

    private static void test3(ResizingArrayDeque<Integer> resizingArrayDeque, NonrecurringInt nonrecurringInt) {
        StdOut.println("Test 3: ");
        pushRightDeque(5, resizingArrayDeque, nonrecurringInt);
        pushLeftDeque(5, resizingArrayDeque, nonrecurringInt);
        popLeftDeque(14, resizingArrayDeque);

        pushRightDeque(5, resizingArrayDeque, nonrecurringInt);
        pushLeftDeque(5, resizingArrayDeque, nonrecurringInt);
        popLeftDeque(14, resizingArrayDeque);
    }

    private static void popLeftDeque (int times, ResizingArrayDeque resizingArrayDeque) {
        StdOut.println("POP LEFT " + times + " times: ");
        for (int i = 0; i < times; i++) {
            printDeque(resizingArrayDeque);
//            StdOut.println("array size: " + resizingArrayDeque.arraySize());
//            StdOut.println("size: " + resizingArrayDeque.size());
            resizingArrayDeque.popLeft();
        }
    }

    private static void popRightDeque (int times, ResizingArrayDeque resizingArrayDeque) {
        StdOut.println("POP RIGHT " + times + " times: ");
        for (int i = 0; i < times; i++) {
            printDeque(resizingArrayDeque);
//            StdOut.println("array size: " + resizingArrayDeque.arraySize());
//            StdOut.println("size: " + resizingArrayDeque.size());
            resizingArrayDeque.popRight();
        }
    }

    private static void pushRightDeque (int times, ResizingArrayDeque<Integer> resizingArrayDeque, NonrecurringInt nonrecurringInt) {
        StdOut.println("PUSH RIGHT " + times + " times: ");
        for (int i = 0; i < times; i++) {
            resizingArrayDeque.pushRight(nonrecurringInt.getInt());
            printDeque (resizingArrayDeque);
//            StdOut.println("array size: " + resizingArrayDeque.arraySize());
//            StdOut.println("size: " + resizingArrayDeque.size());
        }
    }

    private static void pushLeftDeque (int times, ResizingArrayDeque<Integer> resizingArrayDeque, NonrecurringInt nonrecurringInt) {
        StdOut.println("PUSH LEFT " + times + " times: ");
        for (int i = 0; i < times; i++) {
            resizingArrayDeque.pushLeft(nonrecurringInt.getInt());
            printDeque (resizingArrayDeque);
//            StdOut.println("array size: " + resizingArrayDeque.arraySize());
//            StdOut.println("size: " + resizingArrayDeque.size());
        }
    }

    private static void printDeque (ResizingArrayDeque resizingArrayDeque) {
        if (resizingArrayDeque.isEmpty()) {
            StdOut.println("Deque is empty");
        }
        else {
            for (Object i: resizingArrayDeque) {
                StdOut.print(i + " ");
            }
        }
        StdOut.println();
    }
}
