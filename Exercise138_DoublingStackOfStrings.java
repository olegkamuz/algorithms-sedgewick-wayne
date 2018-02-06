import java.util.NoSuchElementException;

public class Exercise138_DoublingStackOfStrings {
    private String[] arr;
    private int N; // amount of stack elements
    public Exercise138_DoublingStackOfStrings(int n){
        arr = new String[n];
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public boolean isFull(){
        return N == arr.length;
    }
    public int size(){
        return N;
    }
    public void push(String string){
        if (isFull()) {
            resize(arr.length * 2);
        }
        arr[N++] = string;
    }
    public String pop(){
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        String temp = arr[--N];
        if (N == arr.length / 4) {
            resize(arr.length / 2);
        }
        arr[N] = null;
        return temp;
    }
    private void resize(int max){
       String[] temp = new String[max];
       for (int i = 0; i < N; i++){
           temp[i] = arr[i];
       }
       arr = temp;
    }
    public int arrSize() {
        return arr.length;
    }
    public void printArrContents() {
        StdOut.print("Contents: ");
        for (int i = 0; i < N; i++) {
            StdOut.print(arr[i] + " ");
        }
        StdOut.println();
        StdOut.print("Amount of contents: " + this.N);
    }
    public static void main(String[] args) {
        Exercise138_DoublingStackOfStrings stack = new Exercise138_DoublingStackOfStrings(1);
        String str = "it was - the best - of times - - - it was - the - -";
        String[] arr = str.split(" ");
        for (String s: arr) {
            if (s.equals("-")) stack.pop();
            else stack.push(s);
        }
        stack.printArrContents();
        StdOut.println();
        StdOut.println("Array size: " + stack.arrSize());
    }
}
