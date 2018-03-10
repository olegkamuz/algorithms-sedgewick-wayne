import java.util.Iterator;

public class GeneralizedQueue<Item> implements GeneralizedQueueAPI<Item>{
    private Item[] arr;
    private int size;

    public static GeneralizedQueue GeneralizedQueue() {
        return new GeneralizedQueue();
    }
    @SuppressWarnings("unchecked")
    public GeneralizedQueue() {
        arr = (Item[]) new Object[1];
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void insert(Item x) {
        if (size + 1 >= arr.length / 2) {
            resize(arr.length * 2);
        }
        arr[size++] = x;
    }
    public Item delete(int k) {
        if (k > arr.length) return null;
        if (size - 1 <= arr.length / 4) resize(arr.length / 2);
        int key = arr.length - k;
        Item temp = arr[key];
        arr[key] = null;
        for (int i = key; i < arr.length; i--) {
            if (i + 1 >= arr.length) arr[i] = arr[i + 1];
            arr[i] = null;
        }
        size--;
        return temp;
    }
    @SuppressWarnings("unchecked")
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < size; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item> {
        int current = 0;
        @Override
        public boolean hasNext() {
            return current < size;
        }

        @Override
        public Item next() {
            return arr[current++];
        }

        @Override
        public void remove() {

        }
    }
}
