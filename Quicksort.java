public class Quicksort {
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
