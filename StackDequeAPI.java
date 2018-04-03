public interface StackDequeAPI<Item> {
    void push(Item item);
    Item pop();
    boolean isEmpty();
    int size();
}
