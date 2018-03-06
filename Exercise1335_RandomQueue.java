public class Exercise1335_RandomQueue {
    public static void main(String[] args) {
        MixedDeck mixedDeck = MixedDeck.MixedDeck();
        RandomQueue<String> randomQueue = RandomQueue.RandomQueue();

        enqueue(13, randomQueue, mixedDeck);
        dequeue(13, randomQueue);

        enqueue(13, randomQueue, mixedDeck);
        sample(4, randomQueue);
    }

    private static void enqueue(int times, RandomQueue<String> randomQueue, MixedDeck mixedDeck) {
        StdOut.println("Enqueue " + times + " times");
        for (int i = 0; i < times; i++) {
            randomQueue.enqueue(mixedDeck.getCard());
        }
        StdOut.println(times + " card(s) Deck: ");
        printRandomQueue(randomQueue);
        StdOut.println();
    }

    private static void dequeue(int times, RandomQueue<String> randomQueue) {
        for (int i = 0; i < times; i++) {
            StdOut.println("Dequeued card: " + randomQueue.dequeue() + ", deck left: ");
            StdOut.println();
            printRandomQueue(randomQueue);
            StdOut.println();
        }
    }

    private static void sample(int times, RandomQueue<String> randomQueue) {
        for (int i = 0; i < times; i++) {
            StdOut.println("Sample: " + randomQueue.sample());
            StdOut.println();
            printRandomQueue(randomQueue);
            StdOut.println();
        }
    }

    private static void printRandomQueue(RandomQueue<String> randomQueue) {
        if (randomQueue.isEmpty()) {
            StdOut.println("Deck is empty");
        } else {
            for (String s : randomQueue) {
                StdOut.println(s);
            }
        }
    }
}
