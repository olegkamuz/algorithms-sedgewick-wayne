import java.util.Arrays;

public class Exercise1415_ThreeSumFaster {
    public static void main(String[] args) throws Exception {
        RandomArray randomArray = new RandomArray();
        int[] a = randomArray.getRandomDistinctArray(20, -20, 20);
        Arrays.sort(a);
        new TwoSumFaster(a);
        new ThreeSumFaster(a);
    }
}
