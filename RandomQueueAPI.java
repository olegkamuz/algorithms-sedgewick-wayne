public interface RandomQueueAPI<Item> {
    // TODO RandomQueue RandomQueue()
    boolean isEmpty();
    void enqueue(Item item);
    Item dequeue();
    Item sample();
}
