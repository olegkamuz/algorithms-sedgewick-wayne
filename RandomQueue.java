import java.util.Iterator;

public class RandomQueue<Item> implements RandomQueueAPI<Item> {
    private int size;
    private Item[] arr;

    @SuppressWarnings("unchecked")
    public static RandomQueue RandomQueue() {
        return new RandomQueue();
    }

    @SuppressWarnings("unchecked")
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < size; i++) {
            temp[i] = arr[i];
            arr[i] = null;
        }
        arr = temp;
    }

    @SuppressWarnings("unchecked")
    public RandomQueue() {
        arr = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        if (size + 1 >= arr.length) {
            resize(arr.length * 2);
        }
        size++;
        arr[size - 1] = item;
    }

    @SuppressWarnings("unchecked")
    public Item dequeue() {
        if (isEmpty()) return null;
        if (size - 1 <= arr.length / 4) {
            resize(arr.length / 2);
        }
        int key = StdRandom.uniform(size);
        Item item = arr[key];
        arr[key] = null;
        for (int i = key; i < size - 1; i++) {
            if (arr[i + 1] != null) {
                arr[i] = arr[i + 1];
                arr[i + 1] = null;
            }
        }
        size--;
        return item;
    }

    public int arrSize() {
        return arr.length;
    }

    @SuppressWarnings("unchecked")
    public Item sample() {
        int key = StdRandom.uniform(size);
        Item item = arr[key];
        for (int i = key; i < size; i++) {
            if (arr[i + 1] != null && i < size) {
                arr[i] = arr[i + 1];
            }
            if (i == size - 1) {
                arr[i] = item;
            }
        }
        return item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        int current;

        public boolean hasNext() {
            return arr[current] != null;
        }

        public Item next() {
            return arr[current++];
        }

        public void remove() {
        }
    }
}
