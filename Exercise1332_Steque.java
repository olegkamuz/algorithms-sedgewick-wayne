public class Exercise1332_Steque {
    public static void main(String[] args) {
        Queue<Integer> nonrecurringInt = makeNonrecurringInt(1000);
        Steque<Integer> steque = new Steque<>();
        int nextInt;

        nextInt = nonrecurringInt.dequeue();
        StdOut.println("Enqueue " + nextInt + " :");
        steque.enqueue(nextInt);
        printSteque(steque);

        nextInt = nonrecurringInt.dequeue();
        StdOut.println("Enqueue " + nextInt + " :");
        steque.enqueue(nextInt);
        printSteque(steque);

        nextInt = nonrecurringInt.dequeue();
        StdOut.println("Enqueue " + nextInt + " :");
        steque.enqueue(nextInt);
        printSteque(steque);

        nextInt = nonrecurringInt.dequeue();
        StdOut.println("Enqueue " + nextInt + " :");
        steque.enqueue(nextInt);
        printSteque(steque);

        nextInt = nonrecurringInt.dequeue();
        StdOut.println("Push " + nextInt + " :");
        steque.push(nextInt);
        printSteque(steque);

        popSteque(steque);
        popSteque(steque);

        nextInt = nonrecurringInt.dequeue();
        StdOut.println("Push " + nextInt + " :");
        steque.push(nextInt);
        printSteque(steque);

        nextInt = nonrecurringInt.dequeue();
        StdOut.println("Enqueue " + nextInt + " :");
        steque.enqueue(nextInt);
        printSteque(steque);

        nextInt = nonrecurringInt.dequeue();
        StdOut.println("Push " + nextInt + " :");
        steque.push(nextInt);
        printSteque(steque);

        popSteque(steque);
        popSteque(steque);
        popSteque(steque);
        popSteque(steque);
        popSteque(steque);
        popSteque(steque);
        popSteque(steque);
        popSteque(steque);
        popSteque(steque);

        nextInt = nonrecurringInt.dequeue();
        StdOut.println("Push " + nextInt + " :");
        steque.push(nextInt);
        printSteque(steque);

        nextInt = nonrecurringInt.dequeue();
        StdOut.println("Push " + nextInt + " :");
        steque.push(nextInt);
        printSteque(steque);

        nextInt = nonrecurringInt.dequeue();
        StdOut.println("Push " + nextInt + " :");
        steque.push(nextInt);
        printSteque(steque);

        nextInt = nonrecurringInt.dequeue();
        StdOut.println("Push " + nextInt + " :");
        steque.push(nextInt);
        printSteque(steque);

        steque.enqueue(nonrecurringInt.dequeue());
        steque.enqueue(nonrecurringInt.dequeue());
        steque.enqueue(nonrecurringInt.dequeue());
        steque.enqueue(nonrecurringInt.dequeue());
        printSteque(steque);
    }
    private static void popSteque(Steque<Integer> steque){
        int poped;
        if(!steque.isEmpty()) {
            poped = steque.pop();
            StdOut.println("Pop the '" + poped + "' :");
            printSteque(steque);
        } else {
            StdOut.println("Steque is empty");
            StdOut.println();
        }
    }
    private static void printSteque(Steque<Integer> steque) {
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
