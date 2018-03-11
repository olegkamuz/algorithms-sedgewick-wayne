import java.util.Iterator;

public class GeneralisedQueueList<Item> implements GeneralizedQueue<Item> {
    public Node last;
    public Node first;
    private int size;

    class Node {
        Item item;
        Node next;
    }

    public static GeneralizedQueue GeneralizedQueue() {
        return new GeneralisedQueueList();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(Item x) {
        Node newNode = new Node();
        newNode.item = x;
        if (first == null) {
            first = last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public Item delete(int k) {
        if (k > size || isEmpty()) return null;
        Node current = first;
        int count = 1;
        Node preKey = null;
        Item tempItem = null;
        while (current != null) {
            if (count == size - k) { // pre Key node
                preKey = current;
            }
            if (count == size - k + 1) { // Key node (to delete and to return)
                tempItem = current.item;
                Node tempNext = current.next;
                current.item = null;
                current.next = null;
                current = tempNext;
                size--;
            }
            if (count == size - k + 2) { // post Key node
                if (preKey != null) preKey.next = current;
                else first = current; // no preKey - first was nulled in previous if
            }
            count++;
            current = current.next;
        }
        return tempItem;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
