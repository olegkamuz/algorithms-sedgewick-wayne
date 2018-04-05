public class TextEditorBuffer<Item> {
    Stack<Item> leftStack = new Stack<>();
    Stack<Item> rightStack = new Stack<>();
    int size;

    public TextEditorBuffer Buffer() {
        return new TextEditorBuffer();
    }

    public void insert(Item item) {
        leftStack.push(item);
    }

    public char delete() {
        return (char) leftStack.pop();
    }

    public void left(int k) {
        rightStack.push(leftStack.pop());
    }

    public void right(int k) {
        leftStack.push(rightStack.pop());
    }

    public int size() {
        return size;
    }
}
