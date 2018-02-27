public class NonrecurringInt extends Queue<Integer> {
    private Queue<Integer> nonrecurringInt;

    public NonrecurringInt(int max) {
        nonrecurringInt = new Queue<>();
        for (int i = 1; i < max; i++) {
            nonrecurringInt.enqueue(i);
        }
    }
    public int getInt() {
        return nonrecurringInt.dequeue();
    }
}
