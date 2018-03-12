public class Producer {
    //todo implant generic
    private Integer[] arr;
    private int count;
    @SuppressWarnings("unchecked")
    public Producer(int max, NonrecurringInt nonrecurringInt) {
        arr = new Integer[max];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nonrecurringInt.getInt();
        }
    }
    public Integer getInt() {
        return arr[count++];
    }
}
