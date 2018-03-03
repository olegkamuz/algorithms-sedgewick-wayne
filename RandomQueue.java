public class RandomQueue<Item> {
    private int size;
    private Item[] arr; //resizing arr
    // TODO resize method
    // TODO resize make object
    @SuppressWarnings("unchecked")
    public RandomQueue(){
        arr = (Item[]) new Object[10];
        size++;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void enqueue(Item item) {
        arr[++size] = item;
    }
    @SuppressWarnings("unchecked")
    public Item dequeue() {
        int key = StdRandom.uniform(size);
        Item item = arr[key];
        arr[key] = null;
        for (int i = key; i < size - 1; i++) {
            if (arr[key + 1] != null) {
                arr[key] = arr[key + 1];
                arr[key + 1] = null;
            }
        }
        size--;
        return item;
    }
    @SuppressWarnings("unchecked")
    public Item sample() {
        int key = StdRandom.uniform(size);
        Item item = arr[key];
        for (int i = key; i < size; i++) {
            if (arr[key + 1] != null && i < size - 1) {
                arr[key] = arr[key + 1];
            }
            if (i == size - 1) {
                arr[key] = item;
            }
        }
        return item;
    }
}
