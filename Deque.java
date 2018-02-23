import java.util.Iterator;

public class Deque<Item> implements DequeAPI<Item> {

    private DoubleNode stackEndLeft;
    private DoubleNode stackStartLeft;
    private DoubleNode stackEndRight;
    private DoubleNode stackStartRight;

    private DoubleNode left;
    private DoubleNode right;

    private int size;

    public Deque<Item> Deque() {
       return new Deque<>();
    }

    public void pushLeft (Item item) {
        DoubleNode newDoubleNode = new DoubleNode();
        newDoubleNode.item = item;
        if (isEmpty()) {
            left = right = newDoubleNode;
        } else {
            left.prev = newDoubleNode;
            newDoubleNode.next = right;
            left = newDoubleNode;
        }
        size++;
    }

    public void pushRight (Item item) {
        DoubleNode newDoubleNode = new DoubleNode();
        newDoubleNode.item = item;
        if (isEmpty()) {
            left = right = newDoubleNode;
        } else {
            left.prev = newDoubleNode;
            newDoubleNode.next = right;
            left = newDoubleNode;
        }
        size++;
    }

    public Item popLeft () {
        return left.item;
    }

    public Item popRight () {
        return left.item;
    }

    public boolean isEmpty() {
        return left == null && right == null;
    }
    public int size() {return size;}
    private class DoubleNode {
        Item item;
        DoubleNode next;
        DoubleNode prev;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item> {
        private DoubleNode current = left;

        public boolean hasNext() {
            return current != null && size != 0;
        }
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
        public void remove() {}
    }
}

