import java.util.Iterator;

public class RandomBag<Item> implements RandomBagAPI<Item> {
    private Node first;
    private Node backupNode;
    private int size;

    public static <Item> RandomBag<Item> RandomBag() {
        return new RandomBag<>();
    }

    public void backup(RandomBag<Item> backupRestore) {
        first = backupRestore.first;
        size = backupRestore.size;
    }

    private class Node {
        Item item;
        Node next;

        Node(Item item, Node next) {
            this.item = item;
            this.next = next;
        }

    }

    public void add(Item item) {
        first = new Node(item, first);
        backupNode = new Node(item, backupNode);
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
            int times = StdRandom.uniform(size);
            Node preCurrent = null;
            for (int i = 0; i < times; i++) {
                if (times > 1 && i == times - 2) preCurrent = current;
                if (i + 1 < times) current = current.next;
            }
            Item temp = current.item;
            if (current.next != null && preCurrent != null) {
                preCurrent.next = current.next;
                current.item = null;
                current.next = null;
                current = null;
                current = first;
            } else if (current.next != null) {
                Node tempCurrent = current.next;
                current.item = null;
                current.next = null;
                current = null;
                current = first = tempCurrent;
            } else if (preCurrent != null) {
                preCurrent.next = null;
                current.item = null;
                current.next = null;
                current = null;
            }
            size--;
            return temp;
        }

        public void remove() {
//            StdOut.println("call of remove method");
        }
    }
}
