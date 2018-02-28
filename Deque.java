import java.util.Iterator;

public class Deque<Item> implements DequeAPI<Item> {

    private DoubleNode left;
    private DoubleNode right;

    private int size;

    public static <Item> Deque<Item> Deque() {
       return new Deque<>();
    }

    public void pushLeft (Item item) {
        DoubleNode newDoubleNode = new DoubleNode();
        newDoubleNode.item = item;
        if (isEmpty()) {
            left = right = newDoubleNode;
        } else if (left.equals(right)) {
            left.prev = newDoubleNode;
            newDoubleNode.next = right;
            left = newDoubleNode;
        } else {
            newDoubleNode.next = left;
            left.prev = newDoubleNode;
            left = newDoubleNode;
        }
        size++;
    }

    public void pushRight (Item item) {
        DoubleNode newDoubleNode = new DoubleNode();
        newDoubleNode.item = item;
        if (isEmpty()) {
            left = right = newDoubleNode;
        } else if (left.equals(right)) {
            right.next = newDoubleNode;
            newDoubleNode.prev = left;
            right = newDoubleNode;
        } else {
            right.next = newDoubleNode;
            newDoubleNode.prev = right;
            right = newDoubleNode;
        }
        size++;
    }

    public Item popLeft () {
        Item item = left.item;
        if (left.equals(right)){
            left.item = null;
            left.next = left.prev = left =  null;
            right.item = null;
            right.prev = right.next = right = null;
            return item;
        }
        left.item = null;
        left = left.next;
        left.prev = null;
        return item;
    }

    public Item popRight () {
        Item item = right.item;
        if (left.equals(right)) {
            left.item = null;
            left.next = left.prev = left = null;
            right.item = null;
            right.prev = right.next = right = null;
            return item;
        }
        right.item = null;
        right = right.prev;
        right.next = null;
        return item;
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

