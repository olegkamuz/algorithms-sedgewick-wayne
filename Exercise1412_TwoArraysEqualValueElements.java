import java.util.Arrays;

public class Exercise1412_TwoArraysEqualValueElements {
    public static void main (String[] args) {
        RandomArray randomArray = new RandomArray();
        int[] randomFirstArray = randomArray.getRandomArray(10, 10);
        Arrays.sort(randomFirstArray);
        int[] randomSecondArray = randomArray.getRandomArray(10, 10);
        Arrays.sort(randomSecondArray);
        new  TwoArraysEqualValueElements(randomFirstArray, randomSecondArray);
    }
}
