import java.util.Iterator;

public class Exercise1334_RandomBag {
    public static void main(String[] args) {
        RandomBag<Integer> randomBag = RandomBag.RandomBag();
        NonrecurringInt nonrecurringInt = new NonrecurringInt(1000);
        randomBag.add(nonrecurringInt.getInt());
        randomBag.add(nonrecurringInt.getInt());
        randomBag.add(nonrecurringInt.getInt());
        randomBag.add(nonrecurringInt.getInt());
        randomBag.add(nonrecurringInt.getInt());
        printRandomBag(randomBag);
    }
    private static void printRandomBag(RandomBag<Integer> randomBag) {
        Iterator<Integer> iterator = randomBag.iterator();
        while (iterator.hasNext()) {
            StdOut.print(iterator.next() + " ");
            iterator.remove();
        }
        randomBag.backup();
        StdOut.println();
    }
}
