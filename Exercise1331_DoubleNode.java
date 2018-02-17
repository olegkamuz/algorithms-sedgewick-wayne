public class Exercise1331_DoubleNode {
    public static void main(String[] args){
        DoubleLinkedList<String> doubleLinkedList = new DoubleLinkedList<>();
        doubleLinkedList.add("first node");
        doubleLinkedList.add("second node");
        doubleLinkedList.add("third node");
        doubleLinkedList.add("forth node");
        StdOut.println("List: ");
        printList(doubleLinkedList);

        doubleLinkedList.insertAtTheBeginning("zero node");
        StdOut.println();
        StdOut.println("Inserted at the beginning");
        printList(doubleLinkedList);

        doubleLinkedList.insertAtTheEnd("fifth node");
        StdOut.println();
        StdOut.println("Inserted at the end");
        printList(doubleLinkedList);

        doubleLinkedList.removeFromTheBeginning();
        StdOut.println();
        StdOut.println("Remove From the beginning");
        StdOut.println();
        printList(doubleLinkedList);

        doubleLinkedList.removeFromTheEnd();
        StdOut.println();
        StdOut.println("Remove From the end");
        StdOut.println();
        printList(doubleLinkedList);

        String key = "second node";
        String item = "node before " + "'" + key + "'";
        doubleLinkedList.insertBeforeNode(key, item);
        StdOut.println();
        StdOut.println("Insert before " + "'" + key  + "'");
        StdOut.println();
        printList(doubleLinkedList);

        String item2 = "node after " + "'" + key + "'";
        doubleLinkedList.insertAfterNode(key, item2);
        StdOut.println();
        StdOut.println("Insert after " + "'" + key + "'");
        StdOut.println();
        printList(doubleLinkedList);

        doubleLinkedList.removeGivenNode(key);
        StdOut.println();
        StdOut.println("Removed " + "'" + key + "'");
        StdOut.println();
        printList(doubleLinkedList);

        String key2 = "first node";
        doubleLinkedList.removeGivenNode(key2);
        StdOut.println();
        StdOut.println("Removed " + "'" + key2 + "'");
        StdOut.println();
        printList(doubleLinkedList);

        String key3 = "forth node";
        doubleLinkedList.removeGivenNode(key3);
        StdOut.println();
        StdOut.println("Removed " + "'" + key3 + "'");
        StdOut.println();
        printList(doubleLinkedList);

    }
    private static void printList(DoubleLinkedList<String> doubleLinkedList) {
        for (String s: doubleLinkedList) {
            StdOut.println(s);
        }
    }
}
