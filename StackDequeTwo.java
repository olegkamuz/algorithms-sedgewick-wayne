public class StackDequeTwo<Item> implements StackDequeAPI<Item> {
    private Deque<Item> deque;
    private int size;

    public StackDequeTwo(Deque<Item> deque) {
        this.deque = deque;
    }

    @Override
    public void push(Item item) {
        size++;
        deque.pushRight(item);
    }

    @Override
    public Item pop() {
        size--;
        return deque.popRight();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
