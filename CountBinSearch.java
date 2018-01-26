public class CountBinSearch extends BinSearch{
    private Counter count;
    private int[] arr;
    private int key;
    public CountBinSearch(int key, int[] arr, Counter count){
        this.key = key;
        this.arr = Quicksort.quicksort(arr);
        this.count = count;
    }
    private int rank() {
        int lo = 0;
        int hi = this.arr.length - 1;
        while (lo <= hi)
        {
            this.count.increment();
            int mid = lo + (hi - lo) / 2;
            if (this.key < this.arr[mid]) hi = mid - 1;
            else if (this.key > this.arr[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
    public int count(){
        if(this.rank() != -1) return this.count.tally();
        return -1;
    }

}
