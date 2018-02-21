import java.util.Iterator;

public class Steque<Item> implements StequeAPI<Item> {
    private Node queueEnd;
    private Node queueStart;
    private Node stackEnd;
    private Node stackStart;
    private Node stequeLast;
    private int size;

    public void push (Item item) {
        Node newNode = new Node();
        newNode.item = item;
        if (isEmpty()) {
            queueEnd = queueStart = stackEnd = stackStart = newNode;
        } else if (queueStart.equals(queueEnd) && queueStart.equals(stackStart) && queueStart.equals(stackEnd)) { // steque with single element
            newNode.next = stackStart;
            stackEnd = newNode;
        } else if (stackStart.equals(stackEnd) && !queueStart.equals(queueEnd)) { // stack with one element, queue more then one
            newNode.next = stackEnd;
            stackEnd = newNode;
        } else if (!stackEnd.equals(stackStart)  && queueStart.equals(queueEnd)) { // stack with more then one element, queue one element
            newNode.next = stackEnd;
            stackEnd = newNode;
        } else if (!stackEnd.equals(stackStart) && !queueStart.equals(queueEnd)) { // stack more, queue more
            newNode.next = stackEnd;
            stackEnd = newNode;
        }
        // push to stack more, queue more
        size++;
    }
    public Item pop () {
        if (isEmpty()) return null;
        Item tempItem = stackEnd.item;
        Node tempNext = stackEnd.next;
        if (stackEnd.equals(stackStart) && !queueStart.equals(queueEnd)) { // one element stack, queue more than one
            stackEnd.item = stackStart.item = null;
            stackEnd.next = stackStart.next = null;
            stackEnd = stackStart = null;
            if (tempNext != null) {
                stackEnd = stackStart = queueStart = tempNext;
            }
        } else if (stackEnd.equals(stackStart) && queueStart.equals(queueEnd)) { // single steque element
            stackEnd.item = stackStart.item = queueStart.item = queueEnd.item = null;
            stackEnd = stackStart = queueStart = queueEnd = null;
        } else if (!stackEnd.equals(stackStart) && !queueStart.equals(queueEnd)) { // more than one stack and more than one queue element
            stackEnd.item = null;
            stackEnd.next = null;
            stackEnd = null;
            stackEnd = tempNext;
        } else if (!stackEnd.equals(stackStart) && queueStart.equals(queueEnd)) {
            stackEnd.item = null;
            stackEnd.next = null;
            stackEnd = null;
            stackEnd = tempNext;
        }
        size--;
        return tempItem;
    }
    public void enqueue (Item item) {
        Node newNode = new Node();
        newNode.item = item;
        if (isEmpty()) { // add first steque element
            queueEnd = queueStart = stackEnd = stackStart = newNode;
        } else {
            if (queueStart.equals(queueEnd) && queueStart.equals(stackStart) && queueStart.equals(stackEnd)) { // enqueue from single steque element
                newNode.next = queueStart;
                queueStart = stackStart = stackEnd = newNode;
            } else if (stackStart.equals(stackEnd) && !queueStart.equals(queueEnd)){ // stack - one element, queue more then one
                newNode.next = queueStart;
                queueStart = stackStart = stackEnd = newNode;
            } else if (!stackStart.equals(stackEnd) && !queueStart.equals(queueEnd)) { // both stack and enqueue have more then one element
                if (stequeLast != null){
                    newNode.next = queueEnd;
                    stequeLast = null;
                } else {
                    newNode.next = queueStart;
                }
                queueStart = stackStart =  newNode;
            } else if (!stackEnd.equals(stackStart) && queueStart.equals(queueEnd)) {// stack more then one, queue one
                stackStart.next = newNode;
                queueEnd = stequeLast = newNode;
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
