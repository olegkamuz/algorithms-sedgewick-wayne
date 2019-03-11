import java.util.Random;

public class RandomArray {
    public int[] getRandomArray(int amount, int max) {
        int[] a = new int[amount];
        Random random = new Random();
        for (int i = 0; i < amount - 1; i++) {
            a[i] = random.nextInt(max + 1);
        }
        return a;
    }
    public int[] getRandomArray(int amount, int max, int min) {
        int[] a = new int[amount];
        Random random = new Random();
        for (int i = 0; i < amount - 1; i++) {
            a[i] = min + random.nextInt(max + 1 - min);
        }
        return a;
    }
}
