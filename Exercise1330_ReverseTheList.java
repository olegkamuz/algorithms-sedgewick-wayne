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
        StdOut.println("Reversed List(Sequential): ");
        StdOut.println();
        printList(reversedList);
        LinkedList<String> reversedAgainList = reversedList.reverseTheListRecursion();
        StdOut.println();
        StdOut.println("Reversed Again List(Recursion): ");
        StdOut.println();
        printList(reversedAgainList);
    }
    private static void printList(LinkedList<String> linkedList) {
        for (String s: linkedList) {
            StdOut.println(s);
        }
    }
}
