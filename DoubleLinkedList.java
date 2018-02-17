import java.util.Iterator;

public class DoubleLinkedList<Item> implements Iterable<Item> {
    private DoubleNode first;
    private DoubleNode last;
    private int size;
    class DoubleNode {
        Item item;
        DoubleNode next;
        DoubleNode prev;
    }
    public void removeFromTheBeginning() {
       if (isEmpty()) return;
       if (first.next != null) {
           first.item = null;
           first = first.next;
           first.prev = null;
       }
    }
    public void removeFromTheEnd() {
       if (isEmpty()) return;
       last.item = null;
       last = last.prev;
       last.next = null;
    }
    public void insertBeforeNode(Item key, Item item) {
        if (isEmpty()) return;
        DoubleNode current = first;
        DoubleNode newNode = new DoubleNode();
        newNode.item = item;
        while (current != null) {
            if (current.item == key) {
                if (current.prev != null) {
                    current.prev.next = newNode;
                    newNode.prev = current.prev;
                }
                current.prev = newNode;
                newNode.next = current;
            }
            current = current.next;
        }
    }
    public void insertAfterNode(Item key, Item item) {
        if (isEmpty()) return;
        DoubleNode current = first;
        DoubleNode newNode = new DoubleNode();
        newNode.item = item;
        while (current != null) {
            if (current.item == key) {
                if (current.next != null) {
                    current.next.prev = newNode;
                    newNode.next = current.next;
                }
                current.next = newNode;
                newNode.prev = current;
            }
            current = current.next;
        }
    }
    public void removeGivenNode(Item key) {
        if (isEmpty()) return;
        DoubleNode current = first;
        while (current != null) {
            if (current.item == key) {
                if (current.prev != null && current.next != null) {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    current.item = null;
                    current.next = null;
                    current.prev = null;
                    break;
                }
                if (current.prev == null) {
                    current.item = null;
                    if (current.next != null) {
                        first = current.next;
                        current.next.prev = null;
                    }
                    current.next = null;
                    break;
                } else { // current.next == null
                    last = current.prev;
                    current.item = null;
                    current.prev = null;
                    last.next = null;
                    break;
                }
            }
            current = current.next;
        }
    }
    public void insertAtTheBeginning(Item item) {
        DoubleNode newNode = new DoubleNode();
        newNode.item = item;
        newNode.next = first;
        first.prev = newNode;
        first = newNode;
    }
    public void insertAtTheEnd(Item item) {
        DoubleNode newNode = new DoubleNode();
        newNode.item = item;
        newNode.prev = last;
        last.next = newNode;
        last = newNode;
    }
    public void add (Item item) {
        DoubleNode newNode = new DoubleNode();
        newNode.item = item;
        if (isEmpty()) first = newNode;
        if (last == null) last = first;
        else {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
        size++;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public Iterator<Item> iterator() {
       return new ListIterator();
    }
    private class ListIterator implements Iterator<Item> {
        private DoubleNode current = first;
        public boolean hasNext() {return current != null;}
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
        public void remove(){}
    }
}
