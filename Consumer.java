public class Consumer {
    private Integer[] arr;
    private int count;
    public Consumer(int max) {
        arr = new Integer[max];
    }
    public void setElement (Integer integer) {
        arr[count++] = integer;
    }
}
