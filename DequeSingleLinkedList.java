import java.util.Iterator;

//public class Deque<Item> implements DequeAPI<Item> {
    public class DequeSingleLinkedList<Item> {

    private Node stackEndLeft;
    private Node stackStartLeft;
    private Node stackEndRight;
    private Node stackStartRight;
    private int size;

    public void pushLeft (Item item) {
        Node newNode = new Node();
        newNode.item = item;
        if (isEmpty()) {
            stackStartLeft =  stackEndLeft = newNode;
        } else if (stackStartLeft == null && stackStartRight != null && stackStartRight.equals(stackEndRight)) { // no , one
            stackStartRight = stackEndRight = newNode;
        } else if (stackStartLeft != null && stackStartLeft.equals(stackEndLeft) && stackStartRight != null && !stackStartRight.equals(stackEndRight)) { // one, more
            stackEndRight.next = newNode;
            stackEndRight = newNode;
        } else if (stackStartLeft != null && !stackStartLeft.equals(stackEndLeft) && stackStartRight != null && stackStartRight.equals(stackEndRight)) { // more, one
            stackStartRight = stackEndRight = newNode;
            stackStartLeft.next = newNode;
        } else if (stackStartLeft != null && !stackStartLeft.equals(stackEndLeft) && stackStartRight != null && !stackStartRight.equals(stackEndRight)) { // more, more
            stackEndRight.next = newNode;
            stackEndRight = newNode;
        } else if (stackStartLeft == null && stackStartRight != null && !stackStartRight.equals(stackEndRight)) { // no, more
            stackEndLeft = stackStartLeft = newNode;
            newNode.next = stackStartRight;
        } else if (stackStartLeft != null && stackStartLeft.equals(stackEndLeft) && stackStartRight == null) { // one, no
            newNode.next = stackEndLeft;
            stackEndLeft = newNode;
        } else if (stackStartLeft != null && !stackStartLeft.equals(stackEndLeft) && stackStartRight == null) { // more, no
            newNode.next = stackEndLeft;
            stackEndLeft = newNode;
        }
        size++;
    }
    public void pushRight (Item item) {
        Node newNode = new Node();
        newNode.item = item;
        if (isEmpty()) {
            stackStartRight = stackEndRight = newNode;
        } else if (stackStartLeft == null && stackStartRight == null) { // no , no
            newNode.next = stackEndRight;
            stackEndRight = stackStartRight = newNode;
        } else if (stackStartLeft != null && stackStartLeft.equals(stackEndLeft) && stackStartRight != null && !stackStartRight.equals(stackEndRight)) { // one, more
            newNode.next = stackEndLeft;
            stackEndLeft = newNode;
        } else if (stackStartLeft != null && !stackStartLeft.equals(stackEndLeft) && stackStartRight != null && stackStartRight.equals(stackEndRight)) { // more, one
            newNode.next = stackEndLeft;
            stackEndLeft = newNode;
        } else if (stackStartLeft != null && !stackStartLeft.equals(stackEndLeft) && stackStartRight != null && !stackStartRight.equals(stackEndRight)) { // more, more
            newNode.next = stackEndLeft;
            stackEndLeft = newNode;
        } else if (stackStartLeft == null && stackStartRight != null && !stackStartRight.equals(stackEndRight)) { // no, more
            stackEndLeft = stackStartLeft = newNode;
            newNode.next = stackStartRight;
        } else if (stackStartLeft != null && stackStartLeft.equals(stackEndLeft) && stackStartRight == null) { // one, no
            newNode.next = stackEndLeft;
            stackEndLeft = newNode;
        } else if (stackStartLeft != null && !stackStartLeft.equals(stackEndLeft) && stackStartRight == null) { // more, no
            newNode.next = stackEndLeft;
            stackEndLeft = newNode;
        }
        size++;
    }
//    public Item popLeft () {
//        if (isEmpty()) return null; // no, no
//        Item tempItem;
//        Node tempNext;
//        if (stackEnd != null) {
//            tempItem = stackEnd.item;
//            tempNext = stackEnd.next;
//        } else {
//            tempItem = queueStart.item;
//            tempNext = queueStart.next;
//        }
//        if (stackStart != null && stackStart.equals(stackEnd) && queueStart != null && !queueStart.equals(queueEnd)) { // one, more
//            stackEnd.item = stackStart.item = null;
//            stackEnd.next = stackStart.next = null;
//            stackEnd = stackStart = null;
//        } else if (stackStart != null && !stackStart.equals(stackEnd) && queueStart != null && !queueStart.equals(queueEnd)) { // more, more
//            stackEnd.item = null;
//            stackEnd.next = null;
//            stackEnd = null;
//            stackEnd = tempNext;
//        } else if (stackStart != null && !stackStart.equals(stackEnd) && queueStart != null && queueStart.equals(queueEnd)) { // more, one
//            stackEnd.item = null;
//            stackEnd.next = null;
//            stackEnd = null;
//            stackEnd = tempNext;
//        } else if (stackStart == null && queueStart != null && !queueStart.equals(queueEnd)) { // no, more
//            queueStart.item = null;
//            queueStart.next = null;
//            queueStart = tempNext;
//        } else if (stackStart == null && queueStart != null && queueStart.equals(queueEnd)) { // no, one
//            queueStart.item = queueEnd.item = null;
//            queueStart.next = null;
//            queueStart = queueEnd = null;
//        }
//        size--;
//        return tempItem;
//    }
//    public Item popRight () {}

    public boolean isEmpty() {
        return stackStartLeft == null && stackStartRight == null;
    }
    public int size() {return size;}
    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item> {
        private Node current;

        private ListIterator() {
            if (stackEndLeft != null) current = stackEndLeft;
            else current = stackStartRight;
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

