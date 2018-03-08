public class Exercise1336_RandomQueueRandomIterator {
    public static void main(String[] args) {
        MixedDeck mixedDeck = MixedDeck.MixedDeck();
        RandomQueueRandomIterator<Card> randomQueue = RandomQueueRandomIterator.RandomQueueRandomIterator();

        // enqueue 13 times, dequeue 13 times, enqueue 13 times, sample 4 times
        test1(randomQueue, mixedDeck);

        // enqueue 4, dequeue 2, sample 2, enqueue 11, dequeue 7, sample 3
        test2(randomQueue, mixedDeck);
    }

    private static void test1 (RandomQueueRandomIterator<Card> randomQueue, MixedDeck mixedDeck){
        StdOut.println("Test 1: ");
        enqueue(13, randomQueue, mixedDeck);
        dequeue(13, randomQueue);

        enqueue(13, randomQueue, mixedDeck);
        sample(4, randomQueue);
    }

    private static void test2 (RandomQueueRandomIterator<Card> randomQueue, MixedDeck mixedDeck){
        StdOut.println("Test 2: ");
        enqueue(4, randomQueue, mixedDeck);
        dequeue(2, randomQueue);
        sample(2, randomQueue);
        enqueue(11, randomQueue, mixedDeck);
        dequeue(7, randomQueue);
        sample(3, randomQueue);
    }

    private static void enqueue(int times, RandomQueueRandomIterator<Card> randomQueue, MixedDeck mixedDeck) {
        StdOut.println("Enqueue " + times + " times ");
        StdOut.println();
        for (int i = 0; i < times; i++) {
            randomQueue.enqueue(mixedDeck.getCard());
        }
        StdOut.println(times + " card(s) bridge hand: ");
        printRandomQueue(randomQueue);
        StdOut.println();
    }

    private static void dequeue(int times, RandomQueueRandomIterator<Card> randomQueue) {
        for (int i = 0; i < times; i++) {
            StdOut.println("Dequeued card: " + randomQueue.dequeue().getCard() + ", bridge hand left: ");
            StdOut.println();
            printRandomQueue(randomQueue);
            StdOut.println();
        }
    }

    private static void sample(int times, RandomQueueRandomIterator<Card> randomQueue) {
        for (int i = 0; i < times; i++) {
            StdOut.println("Sample: " + randomQueue.sample().getCard() + ", brigde hand now is: ");
            StdOut.println();
            printRandomQueue(randomQueue);
            StdOut.println();
        }
    }

    private static void printRandomQueue(RandomQueueRandomIterator<Card> randomQueue) {
        if (randomQueue.isEmpty()) {
            StdOut.println("Deck is empty");
        } else {
            for (Card s : randomQueue) {
                StdOut.println(s.getCard());
            }
        }
    }
}

