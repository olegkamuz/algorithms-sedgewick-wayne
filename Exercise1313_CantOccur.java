public class Exercise1313_CantOccur {
    public static void main(String[] args) {
        checkVersionA();
    }
    private static void checkVersionA() {
        Stack<Integer> stack = makeCycleStack();
        Queue<Integer> a = new Queue<Integer>();
        a.enqueue(cyclePop(stack));
        StdOut.print(a.dequeue() + " ");
        a.enqueue(cyclePop(stack));
        StdOut.print(a.dequeue() + " ");
        a.enqueue(cyclePop(stack));
        StdOut.print(a.dequeue() + " ");
        a.enqueue(cyclePop(stack));
        StdOut.print(a.dequeue() + " ");
        a.enqueue(cyclePop(stack));
        StdOut.print(a.dequeue() + " ");
        a.enqueue(cyclePop(stack));
        StdOut.print(a.dequeue() + " ");
        a.enqueue(cyclePop(stack));
        StdOut.print(a.dequeue() + " ");
        a.enqueue(cyclePop(stack));
        StdOut.print(a.dequeue() + " ");
        a.enqueue(cyclePop(stack));
        StdOut.print(a.dequeue() + " ");
        a.enqueue(cyclePop(stack));
        StdOut.print(a.dequeue() + " ");
    }
    private static Stack<Integer> makeCycleStack(){
        Stack<Integer> stack = new Stack<Integer>();
        fillStack(stack);
        return stack;
    }
    private static void fillStack(Stack<Integer> stack){
        for (int i = 9; i >= 0; i--) {
            stack.push(i);
        }
    }
    private static Integer cyclePop(Stack<Integer> stack){
        if (stack.isEmpty()) fillStack(stack);
        return stack.pop();
    }
}
