import java.util.Iterator;

public class RandomBag<Item> implements RandomBagAPI<Item> {
    private Node first;
    private int size;

    public static <Item> RandomBag<Item> RandomBag() {
        return new RandomBag<>();
    }
    public RandomBag<Item> clone() {
        RandomBag<Item> clone = RandomBag.RandomBag();
        Node current = first;
        while (current != null) {
            clone.add(current.item);
            current = current.next;
        }
        return clone;
    }
    private class Node {
        Item item;
        Node next;
    }

    public void add(Item item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = first;
        first = newNode;
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
        private Node current = first;

        public boolean hasNext() {
            return !isEmpty() && current != null;
        }

        public Item next() {
            int key = StdRandom.uniform(size + 1);
            Node preCurrent = null;
            for (int i = 0; i < key; i++) {
                if (key > 1 && i == key - 2) preCurrent = current;
                if (i + 1 < key) current = current.next;
            }
            Item temp = current.item;
            if (current.next != null && preCurrent != null) { // in the middle
                preCurrent.next = current.next;
                current.item = null;
                current.next = null;
                current = null;
                current = first;
            } else if (current.next != null) { // at the start
                Node tempCurrent = current.next;
                current.item = null;
                current.next = null;
                current = null;
                current = first = tempCurrent;
            } else if (preCurrent != null) { // at the end
                preCurrent.next = null;
                current.item = null;
                current.next = null;
                current = null;
                current = first;
            } else {
                current.item = null;
                current.next = null;
                current = null;
                current = first;
            }
            size--;
            return temp;
        }

        public void remove() {
//            StdOut.println("call of remove method");
        }
    }
}
