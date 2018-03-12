public interface RingBuffer<Item> extends Iterable<Item> {
    boolean isEmpty();
    boolean isFull();
    void insert(Item item);
    Item remove();
    boolean stop = false;
}
