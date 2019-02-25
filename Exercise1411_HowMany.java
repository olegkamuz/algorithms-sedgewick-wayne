import java.util.Arrays;
import java.util.Random;

public class Exercise1411_HowMany {
    public static void main (String[] args) {
        RandomArray getRandomArray = new RandomArray();
        int[] randomArray = getRandomArray.getRandomArray(20);
        int randomKey = new Random().nextInt(5);
        Arrays.sort(randomArray);
        System.out.println("In array: " + Arrays.toString(randomArray));
        System.out.println("Random key: " + randomKey);
        StaticSETofInts staticSETofInts = new StaticSETofInts(randomArray);
        System.out.println("Occurs " + staticSETofInts.howMany(randomKey) + " times");
    }
}
