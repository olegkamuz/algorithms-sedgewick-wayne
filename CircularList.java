import java.util.Iterator;

public class CircularList<Item> implements Iterable<Item> {
    private Node last;
    private int N;

    public Item getItem() {
        return last.item;
    }

    private void linkEnds() {
        Node current = last;
        for(int i = N; i > 0; i--) {
            if (i == 1) current.next = last;
            current = current.next;
        }
    }

    public void add(Item item) {
        Node node = new Node();
        node.item = item;
        if (last == null) {
            last = node;
            node.next = last;
        }  else {
            node.next = last;
            last = node;
        }
        N++;
        linkEnds();
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N != 0;
    }

    private class Node {
        Item item;
        Node next;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = last;
        private int count = 0;
        public boolean hasNext() {
            return count < 3 * N;
        }

        public Item next() {
            count++;
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
        }
    }
}

