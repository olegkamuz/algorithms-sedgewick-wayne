import java.util.Arrays;

public class StaticSETofInts
{
    private int[] a;

    public StaticSETofInts(int[] keys) {
        a = new int[keys.length];
        for (int i = 0; i < keys.length; i++)
            a[i] = keys[i]; // defensive copy
        Arrays.sort(a);
    }

    public boolean contains(int key) {
        return rank(key) != -1;
    }


    private int rank(int key) { // Binary search.
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi)
        { // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

//    public int howMany(int key)
//    {
//        int occurrences = 0;
//        int lo = 0;
//        int hi = a.length - 1;
//        while (lo <= hi)
//        {
//            int mid = lo + (hi - lo) / 2;
//            if (key < a[mid]) {
//                hi = mid - 1;
//            } else if (key > a[mid]) {
//                lo = mid + 1;
//            } else {
//                if (mid == 0 || a[mid] != a[mid-1] /* not enough condition */ && a[mid] != a[mid+1]) {
//                    return 1;
//                }
//                else {
//                    occurrences++;
//                    hi = mid - 1;
//                }
//            }
//        }
//        return occurrences;
//    }

    public int howMany(int key) {
        int lowestIndex =  BinSearchMod.rank(key, a);
        int i = lowestIndex;
        int occurrences = 0;
        while(a[i] == key) {
           occurrences++;
           i++;
        }
        return occurrences;
    }
}










