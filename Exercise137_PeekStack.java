import java.util.Iterator;
import java.util.NoSuchElementException;

public class Exercise137_PeekStack<Item> implements Iterable<Item> {
    private Node first;
    private int N;

    public static void main(String[] args) {
        Exercise137_PeekStack<String> peekStack = new Exercise137_PeekStack<String>();
        peekStack.push("first");
        peekStack.push("second");
        peekStack.push("third");
        StdOut.println("Peek: " + peekStack.peek());
        StdOut.println("Pop: " + peekStack.pop());
        StdOut.println("Peek: " + peekStack.peek());
    }

    private class Node {
        Item item;
        Node next;
    }

    public Item peek() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return this.first.item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Item pop() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
