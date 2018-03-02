import java.util.Iterator;

public class RandomBag<Item> implements RandomBagAPI<Item> {
    private Node first;
    private int size;
    private Node backupNode;

    public static <Item> RandomBag<Item> RandomBag() {
        return new RandomBag<>();
    }

    public void backup() {
        first = backupNode;
    }

    private class Node {
        Item item;
        Node next;

        Node(Item item, Node next) {
            this.item = item;
            this.next = next;
        }

        Node(Node node) {
            this.item = node.item;
            this.next = node.next;
        }
    }

    public void add(Item item) {
        Node newNode = new Node(item, first);
        Node backUpNode = new Node(newNode);
        first = newNode;
        this.backupNode = backUpNode;
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
//            return current != null;
        }

        public Item next() {
//            Item temp = current.item;
//            current = current.next;
//            return temp;

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
                current = first;
            } else if (current.next != null) {
                Node tempCurrent = current.next;
                current.item = null;
                current.next = null;
                current = tempCurrent;
            } else if (preCurrent != null) {
                preCurrent.next = null;
                current.item = null;
                current.next = null;
            }
            size--;
            return temp;
        }

        public void remove() {
//            StdOut.println("call of remove method");
        }
    }
}
