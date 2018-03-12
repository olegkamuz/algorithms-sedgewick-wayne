public interface Deque<Item> extends Iterable<Item> {
    static Deque Deque() {
        return null;
    }
    boolean isEmpty();
    int size();
    void pushLeft(Item item);
    void pushRight(Item item);
    Item popLeft();
    Item popRight();
}
