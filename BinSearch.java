public class BinSearch {
    public static int binSearch(int[] a, int i) {
        int hi = a.length;
        int low = 0;
        int mid;
        while (low < hi) {
            mid = (low - hi)/2;
            if (a[mid] == i) return i;
            if(i > a[mid]) {
                low = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        return -1;
    }
}
