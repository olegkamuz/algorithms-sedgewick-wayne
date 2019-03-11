import java.util.Arrays;

public class Exercise1415_ThreeSumFaster {
    public static void main(String[] args) {
//        int[] a = {-20, -8, -5, 1, 8, 15};
        RandomArray randomArray = new RandomArray();
        int[] a = randomArray.getRandomArray(10, 10, -10);
        Arrays.sort(a);
        new TwoSumFaster(a);
    }
}
