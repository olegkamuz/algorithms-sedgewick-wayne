public class Exercise131_isFull {
    private String[] a; // stack entries
    private int N;

    public Exercise131_isFull(int cap) {
        a = new String[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }
    public boolean isFull(){
        return N == a.length;
    }

    public int size() {
        return N;
    }

    public void push(String item) {
        a[N++] = item;
    }

    public String pop() {
        return a[--N];
    }

    public static void main(String[] args){
        Exercise131_isFull arr = new Exercise131_isFull(3);
        System.out.println("Test isFull method, expected false: " + arr.isFull());
        arr.push("first");
        arr.push("second");
        arr.push("third");
        System.out.println("Test isFull method, expected true: " + arr.isFull());
    }
}
