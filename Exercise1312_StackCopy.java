public class Exercise1312_StackCopy {
    public static void main(String[] args){
        Stack<String> stack = new Stack<String>();
        stack.push("first");
        stack.push("second");
        stack.push("third");

        Stack<String> stackCopy = copy(stack);

        StdOut.print("Original stack address: " + stack + "\nand copy stack address: " + stackCopy);

    }
    private static Stack<String> copy(Stack<String> stack) {
        Stack<String> stackCopy = new Stack<String>();
        for (String s: stack) {
            stackCopy.push(s);
        }
        return stackCopy;
    }
}
