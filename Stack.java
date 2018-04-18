import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

public class Stack<Item> implements Iterable<Item> {
    private Node first;
    private int N;
    private boolean busy;

    private class Node {
        Item item;
        Node next;
    }

    public Stack() {
    }

    public Stack(Stack<Item> s) {
        Stack<Item> temp = new Stack<>();
        for (Item i : s) {
            temp.push(i);
        }
        for (Item item : temp) {
            push(item);
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(Item item) throws  ConcurrentModificationException{
        if (busy) throw new ConcurrentModificationException("Can't change stack while it is iterating");
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop() {
        if (busy) throw new ConcurrentModificationException("Can't change stack while it is iterating");
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.first.item;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Item i : this) {
            stringBuilder.append(i + " ");
        }
        return stringBuilder.toString();
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            boolean is = current != null;
            if (!is) busy = false;
            return is;
        }

        public void remove() {
        }

        public Item next() {
            busy = true;
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
