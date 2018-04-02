import java.util.Iterator;

public class Steque<Item> implements StequeAPI<Item> {
    private Node queueEnd;
    private Node queueStart;
    private Node stackEnd;
    private Node stackStart;
    private int size;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Item item: this) {
            stringBuilder.append(item + " ");
        }
        return stringBuilder.toString();
    }

    public void push (Item item) {
        Node newNode = new Node();
        newNode.item = item;
        if (isEmpty()) {
            stackEnd = stackStart = newNode;
        } else if (stackStart == null && queueStart == null) { // no , no
            newNode.next = stackEnd;
            stackEnd = stackStart = newNode;
        } else if (stackStart != null && stackStart.equals(stackEnd) && queueStart != null && !queueStart.equals(queueEnd)) { // one, more
            newNode.next = stackEnd;
            stackEnd = newNode;
        } else if (stackStart != null && !stackStart.equals(stackEnd) && queueStart != null && queueStart.equals(queueEnd)) { // more, one
            newNode.next = stackEnd;
            stackEnd = newNode;
        } else if (stackStart != null && !stackStart.equals(stackEnd) && queueStart != null && !queueStart.equals(queueEnd)) { // more, more
            newNode.next = stackEnd;
            stackEnd = newNode;
        } else if (stackStart == null && queueStart != null && !queueStart.equals(queueEnd)) { // no, more
            newNode.next = queueStart;
            stackEnd = stackStart = newNode;
        } else if (stackStart != null && stackStart.equals(stackEnd) && queueStart == null) { // one, no
            newNode.next = stackEnd;
            stackEnd = newNode;
        } else if (stackStart != null && !stackStart.equals(stackEnd) && queueStart == null) { // more, no
            newNode.next = stackEnd;
            stackEnd = newNode;
        }
        size++;
    }
    public Item pop () {
        if (isEmpty()) return null; // no, no
        Item tempItem;
        Node tempNext;
        if (stackEnd != null) {
            tempItem = stackEnd.item;
            tempNext = stackEnd.next;
        } else {
            tempItem = queueStart.item;
            tempNext = queueStart.next;
        }
        if (stackStart != null && stackStart.equals(stackEnd) && queueStart != null && !queueStart.equals(queueEnd)) { // one, more
            stackEnd.item = stackStart.item = null;
            stackEnd.next = stackStart.next = null;
            stackEnd = stackStart = null;
        } else if (stackStart != null && !stackStart.equals(stackEnd) && queueStart != null && !queueStart.equals(queueEnd)) { // more, more
            stackEnd.item = null;
            stackEnd.next = null;
            stackEnd = null;
            stackEnd = tempNext;
        } else if (stackStart != null && !stackStart.equals(stackEnd) && queueStart != null && queueStart.equals(queueEnd)) { // more, one
            stackEnd.item = null;
            stackEnd.next = null;
            stackEnd = null;
            stackEnd = tempNext;
        } else if (stackStart == null && queueStart != null && !queueStart.equals(queueEnd)) { // no, more
            queueStart.item = null;
            queueStart.next = null;
            queueStart = tempNext;
        } else if (stackStart == null && queueStart != null && queueStart.equals(queueEnd)) { // no, one
            queueStart.item = queueEnd.item = null;
            queueStart.next = null;
            queueStart = queueEnd = null;
        }
        size--;
        return tempItem;
    }
    public void enqueue (Item item) {
        Node newNode = new Node();
        newNode.item = item;
        if (isEmpty()) { // no, no
            queueEnd = queueStart = newNode;
        } else {
            if (stackEnd == null && queueStart != null && queueStart.equals(queueEnd)) { // no, one
                queueEnd.next = newNode;
                queueEnd = newNode;
            } else if (stackEnd != null && !stackEnd.equals(stackStart) && queueStart == null) { // more, no
                stackStart.next = newNode;
                queueStart = queueEnd = newNode;
            } else if (stackEnd != null && stackEnd.equals(stackStart) && queueStart == null) { // one, no
                stackEnd.next = stackStart.next = newNode;
                queueStart = queueEnd = newNode;
            } else if (stackEnd != null && stackStart.equals(stackEnd) && queueStart != null && !queueStart.equals(queueEnd)){ // one, more
                queueEnd.next = newNode;
                queueEnd = newNode;
            } else if (stackStart != null && !stackStart.equals(stackEnd) && queueStart != null && !queueStart.equals(queueEnd)) { // more, more
                queueEnd.next = newNode;
                queueEnd = newNode;
            } else if (stackStart != null && !stackEnd.equals(stackStart) && queueStart != null && queueStart.equals(queueEnd)) { // more, one
                queueEnd.next = queueStart.next = newNode;
                queueEnd = newNode;
            } else if (stackStart == null && queueStart != null && !queueStart.equals(queueEnd)) { // no, more
                queueEnd.next = newNode;
                queueEnd = newNode;
            }
        }
        size++;
    }

    public boolean isEmpty() {
        return stackEnd == null && stackStart == null && queueStart == null && queueEnd == null;
    }
    public int size() {return size;}
    private class Node {
        Item item;
        Node next;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item> {
        private Node current;

        private ListIterator() {
            if (stackEnd != null) current = stackEnd;
            else current = queueStart;
        }

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

