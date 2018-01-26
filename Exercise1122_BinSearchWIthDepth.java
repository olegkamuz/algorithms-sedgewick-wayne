public class Exercise1122_BinSearchWIthDepth {
    public static void main(String[] args) {
        int[] arr = {3, 56, 30, 213, 7, 4, 9, 324, 10, 2, 8, 5, 1};
        arr = quicksort(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();
        System.out.println(rank(4,arr));
    }

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

    public static int rank(int key, int[] a){
        int indent = 0;
        return rank(key, a, 0, a.length - 1, indent);
    }

    public static int rank(int key, int[] a, int lo, int hi, int indent){
        indent += 2;
        System.out.printf("%" + indent + "d%3d", lo, hi);
        System.out.println();
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) return rank(key, a, lo, mid - 1, indent);
        else if (key > a[mid]) return rank(key, a, mid + 1, hi, indent);
        else return mid;
    }

    public static int[] quicksort(int[] a){
        int temp;
        for(int j = 0; j < a.length; j++){
            for(int i = 0; i < a.length; i++){
                if (a[j] < a[i]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }
}
