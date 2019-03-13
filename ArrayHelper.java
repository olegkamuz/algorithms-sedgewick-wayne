public class ArrayHelper {
    // main idea shift all elements right from index to left
    public static int[] remove(int index, int[] array) {
        int[] temp = new int[array.length - 1];
        for(int i = 0; i < temp.length - 1; i++) {
            if (i < index) {
                temp[i] = array[i];
            } else {
                temp[i] = array[i + 1];
            }
        }
        return temp;
    }
}
