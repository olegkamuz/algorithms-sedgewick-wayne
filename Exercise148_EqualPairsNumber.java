import java.util.Random;

public class Exercise148_EqualPairsNumber {
    public static void main (String[] args) {
        RandomArray randomArray = new RandomArray();
        int[] a = Quicksort.quicksort(randomArray.getRandomArray(20));
        FindEqualPairs.FindEqualPairs(a);
    }
}
