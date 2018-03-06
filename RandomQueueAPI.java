public interface RandomQueueAPI<Item> extends Iterable<Item> {
    static RandomQueue RandomQueue() {
        return new RandomQueue<>();
    }
    boolean isEmpty();
    void enqueue(Item item);
    Item dequeue();
    Item sample();
}
