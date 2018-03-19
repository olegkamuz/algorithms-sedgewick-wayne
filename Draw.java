import java.awt.*;
import java.util.Iterator;

public class Draw {
    private Producer producer;
    private RingBufferArray<Integer> ringBufferArray;
    private Consumer consumer;
    private int timer;
    public static final Color defaultPenColor = new Color(0, 0, 0); // black
    public static final double defaultPenRadius = 0.002;

    public Draw(Producer producer, RingBufferArray<Integer> ringBufferArray, Consumer consumer, int timer) {
        this.producer = producer;
        this.ringBufferArray = ringBufferArray;
        this.consumer = consumer;
        this.timer = timer;
        StdDraw.setCanvasSize(1400, 800);
        StdDraw.setYscale(-0.25, 1.25);
        StdDraw.setXscale(-0.25, 1.25);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(0.1, 1.2, "Producer");
        StdDraw.text(0.1, 0.75, "Buffer");
        StdDraw.text(0.1, 0.35, "Consumer");
        StdDraw.setPenColor(defaultPenColor);
        asyncStart();
    }

    private void drawStart() throws InterruptedException {
        while (timer > 0) {
            Thread.sleep(100);
            drawBuffer();
            drawProducer();
            drawConsumer();
            timer--;
        }
    }


    private void asyncStart() {
        Runnable taskTimer = () -> {
            try {
                drawStart();
            } catch (Exception ex) {
                StdOut.println(ex);
            }
        };
        new Thread(taskTimer, "asyncDrawThread").start();
    }

    private void drawBuffer() {
        Iterator<Integer> nonRemovingIterator = ringBufferArray.nonRemovingIterator();
        int count = 0;
        while (count < ringBufferArray.getArrLength()) {
            double x = 1.0 * count / ringBufferArray.getArrLength();
            double y = 0.55;
            double hw = 0.25 / ringBufferArray.getArrLength();
            double hh = 0.15;
            Integer next = nonRemovingIterator.next();
            if (next != null) {
                StdDraw.setPenColor(StdDraw.BOOK_BLUE);
                StdDraw.filledRectangle(x, y, hw, hh);
                StdDraw.setPenColor(StdDraw.GREEN);
                StdDraw.text(x, y, "" + next);
                StdDraw.setPenColor(defaultPenColor);
            } else {
                StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                StdDraw.filledRectangle(x, y, hw, hh);
                StdDraw.setPenColor(defaultPenColor);
            }
            count++;
        }
    }

    private void drawProducer() throws InterruptedException {
        for (int i = 0; i < producer.getArrSize(); i++) {
            double x = 1.0 * i / producer.getArrSize();
            double y = 0.95;
            double hw = 0.25 / producer.getArrSize();
            double hh = 0.15;
            if (producer.getElement(i) != null) {
                StdDraw.setPenColor(StdDraw.BOOK_BLUE);
                StdDraw.filledRectangle(x, y, hw, hh);
                StdDraw.setPenColor(StdDraw.GREEN);
                StdDraw.text(x, y, "" + producer.getElement(i));
                StdDraw.setPenColor(defaultPenColor);
            } else {
                StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                StdDraw.filledRectangle(x, y, hw, hh);
                StdDraw.setPenColor(defaultPenColor);
            }
        }
    }

    private void drawConsumer() throws InterruptedException {
        for (int i = 0; i < consumer.getArrSize(); i++) {
            double x = 1.0 * i / consumer.getArrSize();
            double y = 0.15;
            double hw = 0.25 / consumer.getArrSize();
            double hh = 0.15;
            if (consumer.getElement(i) != null) {
                StdDraw.setPenColor(StdDraw.BOOK_BLUE);
                StdDraw.filledRectangle(x, y, hw, hh);
                StdDraw.setPenColor(StdDraw.GREEN);
                StdDraw.text(x, y, "" + consumer.getElement(i));
                StdDraw.setPenColor(defaultPenColor);
            } else {
                StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                StdDraw.filledRectangle(x, y, hw, hh);
                StdDraw.setPenColor(defaultPenColor);
            }
        }
    }
}
