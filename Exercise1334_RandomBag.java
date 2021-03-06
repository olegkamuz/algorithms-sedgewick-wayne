import java.util.Iterator;

public class Exercise1334_RandomBag {
    public static void main(String[] args) {
        RandomBag<Integer> randomBag = RandomBag.RandomBag();
        NonrecurringInt nonrecurringInt = new NonrecurringInt(1000);
        addRandomBag(5, randomBag, nonrecurringInt);
        printRandomBagTimes(25, randomBag);
    }

    private static void addRandomBag(int times, RandomBag<Integer> randomBag, NonrecurringInt nonrecurringInt) {
        for (int i = 0; i < times; i++) {
            randomBag.add(nonrecurringInt.getInt());
        }
    }

    private static void printRandomBagTimes(int times, RandomBag<Integer> randomBag) {
        for (int i = 0; i < times; i++) {
            printRandomBag(randomBag);
        }
    }

    private static void printRandomBag(RandomBag<Integer> randomBag) {
        RandomBag<Integer> copy = randomBag.clone();
        for (Integer i : copy) {
            StdOut.print(i + " ");
        }
        StdOut.println();
    }
}
