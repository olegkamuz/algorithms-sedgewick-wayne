public class BinSearchMod {
    public static int rank(int key, int[] a)
    {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                if (mid == 0 || a[mid] != a[mid-1]) return mid;
                else hi = mid - 1;
            }
        }
        return -1;
    }
}

