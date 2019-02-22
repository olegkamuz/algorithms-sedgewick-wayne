import java.util.Random;

public class RandomArray {
    public static int[] getRandomArray(int amount) {
        int[] a = new int[amount];
        Random random = new Random();
        for (int i = 0; i < amount - 1; i++) {
            a[i] = random.nextInt(10);
        }
        return a;
    }
}
