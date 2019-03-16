import java.util.Random;

public class RandomArray{
    public int[] getRandomArray(int amount, int max) {
        int[] a = new int[amount];
        Random random = new Random();
        for (int i = 0; i < amount - 1; i++) {
            a[i] = random.nextInt(max + 1);
        }
        return a;
    }
    public int[] getRandomArray(int amount, int min, int max) {
        int[] a = new int[amount];
        Random random = new Random();
        for (int i = 0; i < amount - 1; i++) {
            a[i] = min + random.nextInt(max + 1 - min);
        }
        return a;
    }
    public double[] getRandomArray(int amount, double min, double max) {
        double[] a = new double[amount];
        Random random = new Random();
        for (int i = 0; i < amount - 1; i++) {
            a[i] = min + (max - min) * random.nextDouble();
        }
        return a;
    }
    public int[] getRandomDistinctArray(int amount, int min, int max) throws Exception{
        int[] b = new int[amount];
        int range = 0;
        if (min < 0) {
            if (max > 0) range = - min + max + 1;
            if (max < 0) range = - min - max;
        } else if (min > 0) {
            if (max > 0) range = max - min;
            if (max < 0) throw new Exception();
        }
        int[] a = new int[range];
        Random random = new Random();
        for (int i = min, j = 0; i <= max && j < range ; i++, j++) {
            a[j] = min++;
        }
        for (int i = 0; i < amount; i++) {
            int randomElement = random.nextInt(max + 1);
            b[i] = a[randomElement];
            a = ArrayHelper.remove(randomElement, a);
        }
        return b;
    }

}

