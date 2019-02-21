import java.util.Random;

public class RandomArray {
    public int[] getRandomArray(int amount) {
        int[] a = new int[40];
        Random random = new Random();
        for (int i = 0; i < amount - 1; i++) {
            a[i] = random.nextInt();
        }
        return a;
    }
}
