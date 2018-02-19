import java.util.Collection;

public interface StequeAPI<Item> extends Iterable<Item> {
    int size();
    boolean isEmpty();
    void enqueue(Item item);
    void push(Item item);
    Item pop();
}
