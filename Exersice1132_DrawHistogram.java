public class Exersice1132_DrawHistogram {
    public static void main(String[] args) {
        double[] sequence = makeSequence();
        showSequence(sequence);
        int N = 10;
        double l = 15.0;
        double r = 27.1;
        double[][] intervals = makeIntervals(N, l, r);
        double[] countHistogram = calculateHistogram(intervals, sequence, N);
        drawHistogram(countHistogram, N);

    }

    private static double[] calculateHistogram(double[][] intervals, double[] sequence, int N) {
        double[] countHistogram = new double[N];
        for (int j = 0; j < intervals.length; j++) {
            double count = 0;
            for (int i = 0; i < sequence.length; i++) {
                if (sequence[i] >= intervals[j][0] && sequence[i] <= intervals[j][1]) {
                    count++;
                }
            }
            countHistogram[j] = count;
            System.out.printf("interval(%.2f:%.2f), count : %1f", intervals[j][0], intervals[j][1], count);
            System.out.println();
        }
        return countHistogram;
    }

    private static void drawHistogram(double[] countHistogram, int N) {
        StdDraw.setCanvasSize(1024, 600);
        StdDraw.setYscale(-1.0, 7.0);
        StdDraw.setXscale(-0.1, 1.1);
        for (int j = 0; j < N; j++) {
            double x = 1.0 * j / N;
            double y = countHistogram[j] / 2.0;
            double hw = 0.25 / N;
            double hh = countHistogram[j] / 2.0;
            StdDraw.filledRectangle(x, y, hw, hh);
        }
    }

    private static double[][] makeIntervals(int N, double l, double r) {
        double range = (l > r) ? (l - r) : (r - l);
        double rangeStart = (l > r) ? r : l;
        double step = range / N;
        double[][] intervals = new double[N][2];
        for (int i = 0; i < N; i++) {
            intervals[i][0] = rangeStart;
            intervals[i][1] = rangeStart + step;
            rangeStart = intervals[i][1];
        }
        return intervals;
    }

    private static double[] makeSequence() {
        int N = 50;
        double lo = 0;
        double hi = 35;
        double[] sequence = new double[N];
        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = (int) Math.round(StdRandom.uniform(lo, hi) * 100) / (double) 100;
        }
        return sequence;
    }

    private static void showSequence(double[] sequence) {
        for (int i = 0; i < sequence.length; i++) {
            System.out.print(sequence[i] + " ");
            if (i != 0 && i % 10 == 0) System.out.println();
        }
        System.out.println();
    }
}
