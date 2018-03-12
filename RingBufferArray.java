import java.util.Iterator;

public class RingBufferArray<Item> implements RingBuffer<Item> {
    private int size;
    private Item[] arr;
    public boolean stop = false;

    @SuppressWarnings("unchecked")
    public RingBufferArray (int max) {
        arr = (Item[]) new Object[max];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == arr.length;
    }

    public void insert(Item item) {
        arr[size++] = item;
    }

    public Item remove() {
        return null;
    }

    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {
        private int current = 0;
        public boolean hasNext() {
            return true;
        }
        public Item next() {
            Item item = arr[current];
            if (item != null) size--;
            arr[current] = null;
            current++;
            if (current == arr.length) current = 0;
            return item;
        }
    }
}
