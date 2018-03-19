import java.util.Iterator;

public class Exercise1339_RingBuffer {
    public static void main(String[] args) throws InterruptedException {

        RingBufferArray<Integer> ringBufferArray = new RingBufferArray<Integer>(10);
        NonrecurringInt nonrecurringInt = new NonrecurringInt(100);

        Consumer consumer = new Consumer(20);
        asyncBufferStart(ringBufferArray, consumer);

        Producer producer = new Producer(20, nonrecurringInt);
        new Draw(producer, ringBufferArray, consumer, 300);
        Thread.sleep(500);
        insert(20, producer, ringBufferArray);

    }

    private static void insert(int times, Producer producer, RingBuffer<Integer> ringBufferArray) throws InterruptedException {
        for (int i = 0; i < times;) {
            StdOut.println(!ringBufferArray.isEmpty());
            if (!ringBufferArray.isFull()) {
                int insert = producer.getInt();
                ringBufferArray.insert(insert);
                Thread.sleep(500);
                i++;
            }
        }
    }

    private static void bufferStart(RingBuffer<Integer> ringBufferArray, Consumer consumer) throws InterruptedException {
        Iterator<Integer> iterator = ringBufferArray.iterator();
        while (true) {
            Thread.sleep(500);
            if (!ringBufferArray.isEmpty()) {
                Integer next = iterator.next();
                if (next != null) {
                    consumer.setElement(next);
                }
            }
            if (ringBufferArray.stop) {
                break;
            }
        }
    }

    private static void asyncBufferStart(RingBuffer<Integer> ringBufferArray, Consumer consumer) {
        Runnable task = () -> {
            try {
                bufferStart(ringBufferArray, consumer);
            } catch (Exception ex) {
                StdOut.println(ex);
            }
        };
        new Thread(task, "asyncBufferThread").start();
    }

    private static void asyncInsertStart(RingBuffer<Integer> ringBufferArray, Consumer consumer) {
        Runnable task = () -> {
            try {
                bufferStart(ringBufferArray, consumer);
            } catch (Exception ex) {
                StdOut.println(ex);
            }
        };
        new Thread(task, "asyncBufferThread").start();
    }
}

