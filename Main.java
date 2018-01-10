public class Main {

    public static void main(String[] args) {
        int[] a = {5, 4, 1, 1, 0, 4, 21, 1, 2, 1};
        int[] histogram = histogram(a, 6);
        for (int i = 0; i < histogram.length; i++) {
            System.out.println("" + i + " : " + histogram[i]);
        }
    }

    public static int[] histogram(int[] a, int M) {
        int[] hist = new int[M];
        for(int i = 0; i < M; i++){
            hist[i] = searchAndCount(a, i);
        }
        return hist;
    }

    public static int searchAndCount(int[] a, int needle) {
        int count = 0;
        for(int i = 0; i < a.length; i++){
            if (a[i] == needle) count++;
        }
        return count;
    }
}
