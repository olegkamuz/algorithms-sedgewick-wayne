public class LinearSearch {
    public int rank(int[] a, int key) {
        int needle = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                needle = i;
            }
        }
        return needle;
    }
}
