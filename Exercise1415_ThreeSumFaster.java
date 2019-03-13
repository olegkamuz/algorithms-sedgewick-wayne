import java.util.Arrays;

public class Exercise1415_ThreeSumFaster {
    public static void main(String[] args) throws Exception {
//        int[] a = {-20, -8, -5, 1, 8, 15};
        RandomArray randomArray = new RandomArray();
        int[] a = randomArray.getRandomDistinctArray(10, -20, 20);
        Arrays.sort(a);
        new TwoSumFaster(a);
    }
}
