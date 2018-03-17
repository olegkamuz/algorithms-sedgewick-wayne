import java.util.Iterator;

public class MoveToFront<Item> implements MoveToFrontAPI<Item> {
    Node first;

    class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(Item item) {
        if (isEmpty()) insertAtFront(item);
        else {
            removeDuplicate(item);
            insertAtFront(item);
        }
    }

    private void insertAtFront(Item item) {
        Node newNode = new Node();
        newNode.item = item;
        if (first == null) first = newNode;
        else {
            newNode.next = first;
            first = newNode;
        }
    }

    public Item getFirst() {
        return first.item;
    }

    private void removeDuplicate(Item item) {
        Node current = first;
        Node temp;
        while (current != null) {
            if (current.next != null) {
                if (current.next.item == item && current.next.next != null) {
                    temp = current.next.next;
                    current.next.next = null;
                    current.next.item = null;
                    current.next = null;
                    current.next = temp;
                }
                if (current.next.item == item) {
                    current.next.item = null;
                    current.next = null;
                }
                current = current.next;
            }
            if (current.item == item && current.next != null) { // first element duplicated
                first = first.next;
                current.item = null;
                current.next = null;
                current = null;
            } else { // single element list
                first.item = null;
                first = null;
                current = null;
            }
        }
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}
