import java.util.Iterator;

public class Steque<Item> implements StequeAPI<Item> {
    private Node queueEnd;
    private Node stackEnd;
    private Node currentQueueNode;
    private int size;

    public void push (Item item) {
        Node newNode = new Node();
        newNode.item = item;
        if (isEmpty()) {
            queueEnd = currentQueueNode = stackEnd =  newNode;
        } else if (stackEnd.equals(currentQueueNode)){
            newNode.next = currentQueueNode;
            stackEnd = newNode;
        } else {
            newNode.next = stackEnd;
            stackEnd = newNode;
        }
        size++;
    }
    public Item pop () {
        if (stackEnd == currentQueueNode && currentQueueNode == queueEnd && stackEnd.next == null){
            Item temp = stackEnd.item;
            queueEnd = null;
            stackEnd.item = null;
            stackEnd.next = null;
            currentQueueNode = null;
            size--;
            return temp;

        }
        Item temp = stackEnd.item;
        Node next = stackEnd.next;
        if (stackEnd.equals(currentQueueNode)) {
            currentQueueNode = next;
        }
        stackEnd.item = null;
        stackEnd.next = null;
        stackEnd = next;
        size--;
        return temp;
    }
    public void enqueue (Item item) {
        Node newNode = new Node();
        newNode.item = item;
        if (isEmpty()) {
            queueEnd = currentQueueNode = stackEnd =  newNode;
        } else if (stackEnd.equals(currentQueueNode)){
            newNode.next = currentQueueNode;
            currentQueueNode = newNode;
            stackEnd = newNode;
        } else {
            stackEnd.next = newNode;
            newNode.next = currentQueueNode;
            currentQueueNode = newNode;
    }
        size++;
    }

    public boolean isEmpty() {return queueEnd == null;}
    public int size() {return size;}
    private class Node {
        Item item;
        Node next;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item> {
        private Node current = stackEnd;
        public boolean hasNext() { return current != null && size != 0; }
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
        public void remove() {}
    }
}
