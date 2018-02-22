public class Exercise1332_Steque {
    public static void main(String[] args) {
        Queue<Integer> nonrecurringInt = makeNonrecurringInt(1000);
        Steque<Integer> steque = new Steque<>();
        // test 1
        StdOut.println("test 1: ");
        StdOut.println();
        // enqueue then push and then pop through all enqueue
        enqueueSteque(3, steque, nonrecurringInt);
        pushSteque(3, steque, nonrecurringInt);
        popSteque(8, steque);

        // test 2
        StdOut.println("test 2: ");
        StdOut.println();
        // push then enqueue and then pop through all stack
        pushSteque(3, steque, nonrecurringInt);
        enqueueSteque(3, steque, nonrecurringInt);
        popSteque(8, steque);

        // test 3
        StdOut.println("test 3: ");
        StdOut.println();
        // enque, push, enque, push
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
