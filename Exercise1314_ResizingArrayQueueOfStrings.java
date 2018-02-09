import java.util.NoSuchElementException;

public class Exercise1314_ResizingArrayQueueOfStrings {
    private String[] arr;
    private int N;

    public Exercise1314_ResizingArrayQueueOfStrings(int max) {
        arr = new String[max];
    }

    public void enqueue(String string) {
        if (isFull()) {
            resize(arr.length * 2);
        }
        arr[N++] = string;
    }

    public String dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (N == arr.length / 4) {
            resize(arr.length / 2);
        }
        String temp = arr[--N];
        arr[N] = null;
        return temp;
    }

    public int size() {
        return N;
    }
    public boolean isFull() {
        return N == arr.length;
    }
    public boolean isEmpty() {
        return N == 0;
    }
    private void resize(int max) {
        String[] temp = new String[max];
        for(int i = 0; i < N; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }
    private int arrSize(){
        return arr.length;
    }

    public static void main(String[] args) {
        Exercise1314_ResizingArrayQueueOfStrings queue = new Exercise1314_ResizingArrayQueueOfStrings(1);
        queue.enqueue("first");
        StdOut.println(queue.arrSize());
        queue.enqueue("second");
        StdOut.println(queue.arrSize());
        queue.enqueue("third");
        StdOut.println(queue.arrSize());
        StdOut.println(queue.dequeue());
        StdOut.println(queue.dequeue());
        StdOut.println(queue.dequeue());
        StdOut.println(queue.arrSize());
    }
}
