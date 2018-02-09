public class Exercise1315_Kth {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        Queue<String> queue = new Queue<String>();
        String[] strings = StdIn.readAllStrings();
        for (int i = 0; i < strings.length; i++) {
            queue.enqueue(strings[i]);
        }
        printKthStrings(queue, k);
    }
    private static void printKthStrings(Queue<String> queue, int k) {
        int count = 0;
        for (String s : queue) {
            count++;
            if (count > queue.size() - k) {
                StdOut.println(s);
            }
        }
    }
}
