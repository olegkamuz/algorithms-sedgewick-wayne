public class StackDequeOne<Item> implements StackDequeAPI<Item> {
    private Deque<Item> deque;
    private int size;

    public StackDequeOne(Deque<Item> deque) {
        this.deque = deque;
    }

    @Override
    public void push(Item item) {
        deque.pushLeft(item);
        size++;
    }

    @Override
    public Item pop() {
        size--;
        return deque.popLeft();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return deque.toString();
    }

}
