import java.util.Arrays;

public class Exercise1410_BinSearchMod {
    public static void main(String[] args) {
        int[] a = RandomArray.getRandomArray(10);
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println(BinSearchMod.rank(4, a));
    }
}
