import java.util.Iterator;

public class RandomQueueRandomIterator<Item> implements RandomQueueAPI<Item> {
    private int size;
    private Item[] arr;
    private int sizeCopy;
    private Item[] arrCopy;

    @SuppressWarnings("unchecked")
    public static RandomQueueRandomIterator RandomQueueRandomIterator() {
        return new RandomQueueRandomIterator();
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
    public RandomQueueRandomIterator() {
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

    public RandomQueueRandomIterator<Item> clone() {
        RandomQueueRandomIterator<Item> copy = RandomQueueRandomIterator.RandomQueueRandomIterator();
        for (int i = 0; i < arr.length; i++) {
            copy.enqueue(arr[i]);
        }
        return copy;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        int current;
        public ListIterator() {
            super();
            arrCopy = (Item[]) new Object[arr.length];
            for (int i = 0; i < arr.length; i++) {
                arrCopy[i] = arr[i];
            }
            sizeCopy = size;
        }

        public boolean hasNext() {
            if(sizeCopy == 0) return false;
            current = StdRandom.uniform(sizeCopy);
            return arrCopy[current] != null;
        }
        public Item next() {
            Item item = arrCopy[current];
            for (int i = current; i < sizeCopy; i++) {
                if (arrCopy[i + 1] != null) {
                    arrCopy[i] = arrCopy[i + 1];
                    arrCopy[i + 1] = null;
                }
            }
            sizeCopy--;
            return item;
        }

        public void remove() {
        }
    }
}

