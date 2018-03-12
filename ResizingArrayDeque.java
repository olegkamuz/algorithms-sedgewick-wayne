import java.util.Iterator;

public class ResizingArrayDeque<Item> implements Deque<Item> {
    private Item[] arr;
    private int size;

    @SuppressWarnings("unchecked")
    private ResizingArrayDeque() {
        arr = (Item[]) new Object[1];
    }

    @SuppressWarnings("unchecked")
    public static <Item> Deque<Item> Deque() {
        return new ResizingArrayDeque<>();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void moveArrRight() {
        for (int i = size - 1; i >= 0; i--) {
            arr[i+1] = arr[i];
            arr[i] = null;
        }
    }

    private void moveArrLeft() {
        for (int i = 0; i < size; i++) {
            arr[i] = arr[i+1];
            arr[i+1] = null;
        }
    }

    @SuppressWarnings("unchecked")
    private void arrayResize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < size; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    public void pushLeft(Item item) {
        if(size + 1 >= arr.length){
            arrayResize(arr.length * 2);
        }
        moveArrRight();
        arr[0] = item;
        size++;
    }

    public void pushRight(Item item) {
        if(size + 1 >= arr.length){
           arrayResize(arr.length * 2);
        }
        arr[size++] = item;
    }

    public Item popLeft() {
        if (!isEmpty()) {
            if(size - 1 <= arr.length / 4){
                arrayResize(arr.length / 2);
            }
            Item temp = arr[0];
            size--;
            moveArrLeft();
            return temp;
        }
        return null;
    }

    public Item popRight() {
        if (!isEmpty()) {
            if(size - 1 <= arr.length / 4){
                arrayResize(arr.length / 2);
            }
            Item temp = arr[size - 1];
            arr[size - 1] = null;
            size--;
            return temp;
        }
        return null;
    }

    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }
    private class ArrayIterator implements Iterator<Item> {
        private int current = 0;
        public boolean hasNext(){
            return current < size;
        }
        public Item next(){
            return arr[current++];
        }
        @Override
        public void remove() {}
    }

}
