public class TextEditorBuffer<Item> {
    Stack<Item> leftStack = new Stack<>();
    Stack<Item> rightStack = new Stack<>();
    int size;

    @Override
    public String toString() {
        return leftStack.toString();
    }

    public TextEditorBuffer Buffer() {
        return new TextEditorBuffer();
    }

    public void insert(Item item) {
        leftStack.push(item);
    }

    public char delete() {
        char c =(char) leftStack.pop();
        if (leftStack.isEmpty()) leftStack.push(rightStack.pop());
        return c;
    }

    public void left(int k) {
        for (int i = 0; i < k; i++) {
            rightStack.push(leftStack.pop());
        }
    }

    public void right(int k) {
        for (int i = 0; i < k; i++) {
            leftStack.push(rightStack.pop());
        }
    }

    public int size() {
        return size;
    }
}
