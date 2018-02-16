public class Exercise1329_CircularList {
    public static void main(String[] args) {
        CircularList<Integer> circularList = new CircularList<>();
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        circularList.add(4);
        circularList.add(5);
        circularList.add(6);
        printList(circularList);
    }
    private static void printList(CircularList<Integer> circularList) {
        StdOut.println("Three circles: ");
        for (Integer s: circularList) {
            StdOut.println(s);
        }
    }
}
