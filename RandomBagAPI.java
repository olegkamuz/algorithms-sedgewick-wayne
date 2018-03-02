public interface RandomBagAPI<Item> extends Iterable<Item> {
    static RandomBag RandomBag() {
        return new RandomBag<>();
    }
    boolean isEmpty();
    int size();
    void add(Item item);
}
