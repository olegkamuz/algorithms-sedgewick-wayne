public class Exercise1330_ReverseTheList {
    public static void main(String[] args){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("first node");
        linkedList.add("second node");
        linkedList.add("third node");
        linkedList.add("forth node");
        printList(linkedList);
        LinkedList<String> reversedList =  linkedList.reverseTheList();
        StdOut.println();
        StdOut.println("Reversed List: ");
        StdOut.println();
        printList(reversedList);
    }
    private static void printList(LinkedList<String> linkedList) {
        for (String s: linkedList) {
            StdOut.println(s);
        }
    }
}
