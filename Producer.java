public class Producer {
    private Integer[] arr;
    private int count;
    @SuppressWarnings("unchecked")
    public Producer(int max, NonrecurringInt nonrecurringInt){
        arr = new Integer[max];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nonrecurringInt.getInt();
        }
    }
    public int getArrSize() {
        return arr.length;
    }
    public Integer getElement(int i) {
        return arr[i];
    }
    public Integer getInt() {
        Integer temp = arr[count];
        arr[count] = null;
        count++;
        return temp;
    }
}
