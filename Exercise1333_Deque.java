public class Exercise1333_Deque {
    public static void main(String[] args) {
        Queue<Integer> nonrecurringInt = makeNonrecurringInt(1000);
        Deque<Integer> deque = new Deque<>();

        // enqueue, push, pop all
        test1(deque, nonrecurringInt);

        // push, enqueue, pop all
//        test2(deque, nonrecurringInt);

        // enqueue, push, enqueue, push, pop all
//        test3(deque, nonrecurringInt);
    }
    private static void test1 (Deque deque, Queue<Integer> nonrecurringInt){
        StdOut.println("test 1: ");
        StdOut.println();
//        pushDequeRight(3, deque, nonrecurringInt);
        pushDequeLeft(3, deque, nonrecurringInt);
//        popDequeLeft(8, deque);
    }
    private static void test2 (Deque deque, Queue<Integer> nonrecurringInt){
        StdOut.println("test 2: ");
        StdOut.println();
        pushDequeLeft(3, deque, nonrecurringInt);
        pushDequeRight(3, deque, nonrecurringInt);
        popDequeLeft(8, deque);
    }
    private static void test3 (Deque deque, Queue<Integer> nonrecurringInt){
        StdOut.println("test 3: ");
        StdOut.println();
        pushDequeRight(2, deque, nonrecurringInt);
        pushDequeLeft(2, deque, nonrecurringInt);
        pushDequeRight(2, deque, nonrecurringInt);
        pushDequeLeft(2, deque, nonrecurringInt);
        popDequeLeft(15, deque);
    }
    private static void pushDequeRight(int times, Deque<Integer> deque, Queue<Integer> nonrecurringInt) {
        int nextInt;
        for (int i = 0; i < times; i++) {
            nextInt = nonrecurringInt.dequeue();
            StdOut.println("Deque after ENQUEUE '" + nextInt + "' :");
//            deque.enqueue(nextInt);
//            printDeque(deque);
        }
    }
    private static void pushDequeLeft(int times, Deque<Integer> deque, Queue<Integer> nonrecurringInt) {
        int nextInt;
        for (int i = 0; i < times; i++) {
            nextInt = nonrecurringInt.dequeue();
            StdOut.println("Deque after PUSH '" + nextInt + "' :");
            deque.pushLeft(nextInt);
            printDeque(deque);
        }
    }
    private static void popDequeLeft(int times, Deque<Integer> deque){
        int poped;
        for (int i = 0; i < times; i++) {
            if(!deque.isEmpty()) {
//                poped = deque.popLeft();
//                StdOut.println("Deque after POP the '" + poped + "' :");
//                printDeque(deque);
            } else {
                StdOut.println("Deque is empty");
                StdOut.println();
            }
        }
    }

    private static void printDeque(Deque<Integer> deque) {
        if(deque.isEmpty()) {
            StdOut.println("Deque is empty");
        }
        for (Integer s: deque) {
            StdOut.println(s);
        }
        StdOut.println();
    }

    private static Queue<Integer> makeNonrecurringInt(int max) {
        Queue<Integer> nonrecurring = new Queue<>();
        for (int i = 1; i < max; i++) {
            nonrecurring.enqueue(i);
        }
        return nonrecurring;
    }
}

