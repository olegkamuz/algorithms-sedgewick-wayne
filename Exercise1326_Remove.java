public class Exercise1326_Remove {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("first node");
        linkedList.add("second node");
        linkedList.add("third node");
        linkedList.add("forth node");
        linkedList.add("third node");
        linkedList.remove("third node");
        printList(linkedList);
    }
    private static void printList(LinkedList<String> linkedList) {
        for (String s: linkedList) {
            StdOut.println(s);
        }
    }
}

