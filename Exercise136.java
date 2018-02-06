public class Exercise136 {
    private static void checkTheCode(Queue<String> queue) {
        Stack<String> stack = new Stack<>();

        while (!queue.isEmpty()) {
            stack.push(queue.dequeue());
        }

        while(!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.enqueue("one");
        queue.enqueue("two");
        queue.enqueue("three");


        StdOut.print("Before code queue: ");
        for(String string : queue) {
            StdOut.print(string + " ");
        }
        StdOut.println();

        checkTheCode(queue);

        StdOut.print("After code queue: ");
        for(String string : queue) {
            StdOut.print(string + " ");
        }
        StdOut.println("Code reverses the queue");
    }

}
