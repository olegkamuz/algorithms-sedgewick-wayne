import java.util.Iterator;

public class RingBufferArray<Item> implements RingBuffer<Item> {
    private int size;
    private int place;
    private Item[] arr;

    @SuppressWarnings("unchecked")
    public RingBufferArray (int max) {
        arr = (Item[]) new Object[max];
    }

    public int getArrLength() {
        return arr.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == arr.length;
    }

    public  void insert(Item item) {
        boolean flag = true;
        if (place + 2 == arr.length + 1) place = 0;
        if (arr[place] == null) {
            arr[place++] = item;
            size++;
        } else {
            while (flag) {
                place++;
                if (arr[place] == null) {
                    arr[place] = item;
                    size++;
                    flag = false;
                }
            }
        }
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
        public  Item next() {
            StdDraw.setPenRadius(0.005);
            drawBufferPointer();
            StdDraw.setPenRadius(Draw.defaultPenRadius);
            Item item = arr[current];
            if (item != null) size--;
            arr[current] = null;
            current++;
            if (current == arr.length) current = 0;
            return item;
        }
        private void clearDrawnPointers() {
            for (int i = 0; i < arr.length; i++) {
                double x1 = 1.0 * i / arr.length;
                double y1 = 0.55;
                double hw1 = 0.25 / arr.length;
                double hh1 = 0.15;
                StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                StdDraw.rectangle(x1, y1, hw1, hh1);
                StdDraw.setPenColor(Draw.defaultPenColor);
            }
        }
        private void drawBufferPointer() {
            clearDrawnPointers();
            double x = 1.0 * current / arr.length;
            double y = 0.55;
            double hw = 0.25 / arr.length;
            double hh = 0.15;
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.rectangle(x, y, hw, hh);
            StdDraw.setPenColor(Draw.defaultPenColor);
        }
    }


    public Iterator<Item> nonRemovingIterator() {
        return new ArrayNonRemovingIterator();
    }

    private class ArrayNonRemovingIterator implements Iterator<Item> {
        private int current = 0;
        public boolean hasNext() {
            return current < size;
        }
        public Item next() {
            return arr[current++];
        }
    }
}
