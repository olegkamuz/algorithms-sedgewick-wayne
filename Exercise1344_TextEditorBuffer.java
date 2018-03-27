public class Exercise1344_TextEditorBuffer {
    public static void main(String[] args) {
        TextEditorBuffer<Character> textEditorBuffer = new TextEditorBuffer<>();
        textEditorBuffer.insert('R');
        textEditorBuffer.insert('o');
        textEditorBuffer.insert('c');
        textEditorBuffer.insert('k');

        textEditorBuffer.left(3);
        StdOut.println("Expected: R");
        StdOut.println(textEditorBuffer.delete());

        textEditorBuffer.right(1);
        StdOut.println("Expected: c");
        StdOut.println(textEditorBuffer.delete());

        textEditorBuffer.insert('s');
        StdOut.println("Expected: s");
        StdOut.println(textEditorBuffer.delete());
    }
}
