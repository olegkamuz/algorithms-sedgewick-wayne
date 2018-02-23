public class Exercise1332_Steque {
    public static void main(String[] args) {
        Queue<Integer> nonrecurringInt = makeNonrecurringInt(1000);
        Steque<Integer> steque = new Steque<>();

        // enqueue, push, pop all
        test1(steque, nonrecurringInt);

        // push, enqueue, pop all
        test2(steque, nonrecurringInt);

        // enqueue, push, enqueue, push, pop all
        test3(steque, nonrecurringInt);
    }
    private static void test1 (Steque steque, Queue<Integer> nonrecurringInt){
        StdOut.println("test 1: ");
        StdOut.println();
        enqueueSteque(3, steque, nonrecurringInt);
        pushSteque(3, steque, nonrecurringInt);
        popSteque(8, steque);
    }
    private static void test2 (Steque steque, Queue<Integer> nonrecurringInt){
        StdOut.println("test 2: ");
        StdOut.println();
        pushSteque(3, steque, nonrecurringInt);
        enqueueSteque(3, steque, nonrecurringInt);
        popSteque(8, steque);
    }
    private static void test3 (Steque steque, Queue<Integer> nonrecurringInt){
        StdOut.println("test 3: ");
        StdOut.println();
        enqueueSteque(2, steque, nonrecurringInt);
        pushSteque(2, steque, nonrecurringInt);
        enqueueSteque(2, steque, nonrecurringInt);
        pushSteque(2, steque, nonrecurringInt);
        popSteque(15, steque);
    }
    private static void enqueueSteque(int times, Steque<Integer> steque, Queue<Integer> nonrecurringInt) {
        int nextInt;
        for (int i = 0; i < times; i++) {
            nextInt = nonrecurringInt.dequeue();
            StdOut.println("Steque after ENQUEUE '" + nextInt + "' :");
            steque.enqueue(nextInt);
            printSteque(steque);
        }
    }
    private static void pushSteque(int times, Steque<Integer> steque, Queue<Integer> nonrecurringInt) {
        int nextInt;
        for (int i = 0; i < times; i++) {
            nextInt = nonrecurringInt.dequeue();
            StdOut.println("Steque after PUSH '" + nextInt + "' :");
            steque.push(nextInt);
            printSteque(steque);
        }
    }
    private static void popSteque(int times, Steque<Integer> steque){
        int poped;
        for (int i = 0; i < times; i++) {
            if(!steque.isEmpty()) {
                poped = steque.pop();
                StdOut.println("Steque after POP the '" + poped + "' :");
                printSteque(steque);
            } else {
                StdOut.println("Steque is empty");
                StdOut.println();
            }
        }
    }
    private static void printSteque(Steque<Integer> steque) {
        if(steque.isEmpty()) {
            StdOut.println("Steque is empty");
        }
        for (Integer s: steque) {
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
