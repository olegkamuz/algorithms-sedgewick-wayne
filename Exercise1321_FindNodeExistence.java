public class Exercise1321_FindNodeExistence {
    public static void main(String[] args){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("first node");
        linkedList.add("second node");
        linkedList.add("third node");
        linkedList.add("forth node");
        printList(linkedList);
        StdOut.println();
        StdOut.println(linkedList.find("second node"));
    }
    private static void printList(LinkedList<String> linkedList) {
        for (String s: linkedList) {
            StdOut.println(s);
        }
    }
}

