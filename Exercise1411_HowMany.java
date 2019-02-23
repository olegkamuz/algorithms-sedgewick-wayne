import java.util.Arrays;
import java.util.Random;

public class Exercise1411_HowMany {
    public static void main (String[] args) {
//        int[] a = {1, 1, 1, 4, 3, 9, 7, 7, 5, 7, 6, 9, 1, 3, 0, 5, 0, 2, 1, 0};
//        int key = 1;
        int[] randomArray = RandomArray.getRandomArray(20);
        int randomKey = new Random().nextInt(5);
        Arrays.sort(randomArray);
        System.out.println("In array: " + Arrays.toString(randomArray));
        System.out.println("Random key: " + randomKey);
        StaticSETofInts staticSETofInts = new StaticSETofInts(randomArray);
        System.out.println("Occurs " + staticSETofInts.howMany(randomKey) + " times");
    }
}
