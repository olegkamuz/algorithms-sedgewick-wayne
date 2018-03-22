public class Exercise1340_MoveToFront {
    public static void main(String[] args) {
        testMiddleElement();
        testFirstElement();
        testLastElement();
        testSingleElementList();
    }

    private static void testSingleElementList() {
        StdOut.println();
        MoveToFrontAPI<Integer> moveToFront = new MoveToFront<>();
        NonrecurringInt nonrecurringInt = new NonrecurringInt(100);
        insert(1, moveToFront, nonrecurringInt);
        StdOut.println("Tested list: ");
        print(moveToFront);
        Integer item = 1;
        StdOut.println("Test middle element '" + item + "': ");
        moveToFront.insert(item);
        print(moveToFront);
    }

    private static void testMiddleElement() {
        StdOut.println();
        MoveToFrontAPI<Integer> moveToFront = new MoveToFront<>();
        NonrecurringInt nonrecurringInt = new NonrecurringInt(100);
        insert(5, moveToFront, nonrecurringInt);
        StdOut.println("Tested list: ");
        print(moveToFront);
        Integer item = 3;
        StdOut.println("Test middle element '" + item + "': ");
        moveToFront.insert(item);
        print(moveToFront);
    }

    private static void testFirstElement() {
        StdOut.println();
        MoveToFrontAPI<Integer> moveToFront = new MoveToFront<>();
        NonrecurringInt nonrecurringInt = new NonrecurringInt(100);
        insert(5, moveToFront, nonrecurringInt);
        StdOut.println("Tested list: ");
        print(moveToFront);
        Integer item = 5;
        StdOut.println("Test first element '" + item + "': ");
        moveToFront.insert(item);
        print(moveToFront);
    }

    private static void testLastElement() {
        StdOut.println();
        MoveToFrontAPI<Integer> moveToFront = new MoveToFront<>();
        NonrecurringInt nonrecurringInt = new NonrecurringInt(100);
        insert(5, moveToFront, nonrecurringInt);
        StdOut.println("Tested list: ");
        print(moveToFront);
        Integer item = 1;
        StdOut.println("Test last element '" + item + "': ");
        moveToFront.insert(item);
        print(moveToFront);
    }


    private static void insert(int times, MoveToFrontAPI<Integer> moveToFront, NonrecurringInt nonrecurringInt) {
        for (int i = 0; i < times; i++) {
            moveToFront.insert(nonrecurringInt.getInt());
        }
    }

    private static void print(MoveToFrontAPI<Integer> moveToFront) {
        for (Integer i : moveToFront) {
            StdOut.print(i + " ");
        }
        StdOut.println();
    }
}
