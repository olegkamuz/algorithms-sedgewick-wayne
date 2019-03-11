import java.util.Arrays;

public class Exercise1410_BinSearchMod {
    public static void main(String[] args) {
        RandomArray randomArray = new RandomArray();
        int[] a = randomArray.getRandomArray(10, 10);
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println(BinSearchMod.rank(4, a));
    }
}
