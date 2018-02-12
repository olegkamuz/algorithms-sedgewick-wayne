public class Exercise1320_DeleteNode {
public static void main(String[] args){
    LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("first node");
        linkedList.add("second node");
        linkedList.add("third node");
        linkedList.add("forth node");
        printList(linkedList);
        linkedList.delete(1);
        StdOut.println();
        printList(linkedList);
    }
    private static void printList(LinkedList<String> linkedList) {
        for (String s: linkedList) {
            StdOut.println(s);
        }
    }
}

