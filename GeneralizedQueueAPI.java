public interface GeneralizedQueueAPI<Item> extends Iterable<Item> {
    static GeneralizedQueue GeneralizedQueue() {
        return new GeneralizedQueue();
    }
    boolean isEmpty();
    void insert(Item x);
    Item delete(int k);
}
