public class Main {

    public static void main(String[] args) {
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
