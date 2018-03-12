import java.util.Iterator;

public class Exercise1339_RingBuffer {
    public static void main(String[] args) throws InterruptedException {
        asyncTimerStart();

        RingBufferArray<Integer> ringBufferArray = new RingBufferArray<>(10);
        NonrecurringInt nonrecurringInt = new NonrecurringInt(100);
        Iterator<Integer> iterator = ringBufferArray.iterator();
        Consumer consumer = new Consumer(10);
        asyncBufferStart(ringBufferArray, iterator, consumer);


        Thread.sleep(3000);
        Producer producer = new Producer(10, nonrecurringInt);
        StdOut.println("Producer initialized");
        insert(5, producer, ringBufferArray);

        Thread.sleep(3000);
        ringBufferArray.stop = true;
    }

    private static void insert(int times, Producer producer, RingBuffer<Integer> ringBufferArray) throws InterruptedException {
        for (int i = 0; i < times; i++) {
            if (!ringBufferArray.isFull()) {
                int insert = producer.getInt();
                ringBufferArray.insert(insert);
                StdOut.println("'" + insert + "' inserted");
            }
            Thread.sleep(100);
        }
    }

    private static void bufferStart(RingBuffer<Integer> ringBufferArray, Iterator<Integer> iterator, Consumer consumer) throws InterruptedException {
        StdOut.println("Buffer started");
        while (true) {
            Thread.sleep(10);
            if (!ringBufferArray.isEmpty()) {
                Integer next = iterator.next();
                if (next != null) {
                    consumer.setElement(next);
                    StdOut.println("Consumer get '" + next + "' element");
                }
            }
            if (ringBufferArray.stop) {
                StdOut.println("Buffer stopped");
                break;
            }
        }
    }

    private static void timerStart() throws InterruptedException {
        int timer = 1;
        while (timer < 5) {
            Thread.sleep(1000);
            StdOut.println("Timer: " + timer++ + " second(s)");
        }
    }

    private static void asyncBufferStart(RingBuffer<Integer> ringBufferArray, Iterator<Integer> iterator, Consumer consumer) {
        Runnable task = () -> {
            try {
                bufferStart(ringBufferArray, iterator, consumer);
            } catch (Exception ex) {
                StdOut.println(ex);
            }
        };
        new Thread(task, "asyncBufferThread").start();
    }

    private static void asyncTimerStart() {
        Runnable taskTimer = () -> {
            try {
                timerStart();
            } catch (Exception ex) {
                StdOut.println(ex);
            }
        };
        new Thread(taskTimer, "asyncTimerThread").start();
    }
}
