public interface GeneralizedQueue<Item> extends Iterable<Item> {
    static GeneralizedQueue GeneralizedQueue() { return null; }
    boolean isEmpty();
    void insert(Item x);
    Item delete(int k);
}
