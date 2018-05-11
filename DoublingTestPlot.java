import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DoublingTestPlot {
    private int numberOfTests;
    private boolean cached;
    public DoublingTestPlot(int numberOfTests, boolean cached){
       this.numberOfTests = numberOfTests;
       this.cached = cached;
    }
    public void plot() throws InterruptedException, IOException {
        setDrawSettings();
        double[][] NAndTime = new double[numberOfTests][2];
        int NAndTimeSize = 0;
        double max;

        if (cached) {
            int countDoubles = 0;
            File file = new File("cache.txt");
            if (file.createNewFile()){
                System.out.println("cache file is created");
            }

            In in = new In("cache.txt");
            double[] doubles = in.readAllDoubles();

            for (int i = 0; i < doubles.length / 2; i++) {
                NAndTime[i][0] = doubles[countDoubles++];
                NAndTime[i][1] = doubles[countDoubles++];
            }

            FileWriter writer = new FileWriter(file);
            for (int i =  0; i <= 3; i++) {
                double N = 1000.0 * Math.pow(2, i);
                if (NAndTime[i][0] == N) {
                    max = NAndTime[i][1];
                    StdOut.println(N + " " + NAndTime[i][1]);
                    NAndTimeSize++;
                } else {
                    double time = DoublingTest.timeTrial((int) N);
                    StdOut.println(N + " " + time);
                    max = time;
                    NAndTime[i][0] = N;
                    NAndTime[i][1] = time;
                    writer.append(NAndTime[i][0] + " " + NAndTime[i][1] + " ");
                    NAndTimeSize++;
                }
                StdDraw.clear();
                drawNormalPlot(NAndTime, NAndTimeSize, max);
                drawLogPlot(NAndTime, NAndTimeSize, max);
                drawNormalCurve(NAndTime, NAndTimeSize, max);
                drawLogCurve(NAndTime, NAndTimeSize, max);
                Thread.sleep(1000);
            }
            writer.close();
        } else {
            for (int i =  0; i <= 3; i++) {
                double N = 1000.0 * Math.pow(2, i);
                double time = DoublingTest.timeTrial((int) N);
                StdOut.println(N + " " + time);
                max = time;
                NAndTime[i][0] = N;
                NAndTime[i][1] = time;
                NAndTimeSize++;
                StdDraw.clear();
                drawNormalPlot(NAndTime, NAndTimeSize, max);
                drawLogPlot(NAndTime, NAndTimeSize, max);
                drawNormalCurve(NAndTime, NAndTimeSize, max);
                drawLogCurve(NAndTime, NAndTimeSize, max);
                Thread.sleep(1000);
            }
        }

    }

    private void drawNormalPlot(double[][] NAndTime, int NAndTimeSize, double max) {
        // X axis
        StdDraw.line(0.0, 0.0, 1.1, 0.0);
        // Y axis
        StdDraw.line(0.0, 0.0, 0.0, 1.1);

        for (int i = 0; i < NAndTimeSize; i++) {
            // X axis serifs
            StdDraw.line(0.0, NAndTime[i][1] / max, -0.05, NAndTime[i][1] / max);
            // Y axis serifs
            StdDraw.line(NAndTime[i][0] * 0.0001, 0.0, NAndTime[i][0] * 0.0001, -0.05);
            // Y axis digits
            StdDraw.text(-0.1, NAndTime[i][1] / max, NAndTime[i][1] + "");
            // X axis digits
            StdDraw.text(NAndTime[i][0] * 0.0001, -0.1, (int) (NAndTime[i][0] * 0.001) + "K");
        }

        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.text(0.0, 1.2, "standard plot");
        StdDraw.text(0.5 ,-0.2, "problem size N");
        StdDraw.text(1.96, -0.2, "lg N");

        StdDraw.text(-0.3, 0.57, "running");
        StdDraw.text(-0.3, 0.5, "time");
        StdDraw.text(-0.3, 0.43, "T(N)");

        StdDraw.text(1.4, 0.5, "lg(T(N))");

        StdDraw.text(1.8, 1.2, "log-log plot");
        StdDraw.setPenColor(StdDraw.BLACK);
    }

    private void setDrawSettings() {
        StdDraw.setCanvasSize(1000, 500);
        StdDraw.setXscale(-0.5, 3.0);
        StdDraw.setYscale(-0.5, 1.5);
        Font font = new Font("SansSerif", Font.PLAIN, 12);
        StdDraw.setFont(font);
    }

    private void drawNormalCurve(double[][] NAndTime, int NAndTimeSize, double max) {
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(StdDraw.getPenRadius() + 0.009);
        for (int i = 0; i < NAndTimeSize; i++) {
            StdDraw.point(NAndTime[i][0] * 0.0001, NAndTime[i][1] / max);
        }
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(StdDraw.getPenRadius() - 0.009);
        for (int i = 0; i < NAndTimeSize - 1; i++) {
            StdDraw.line(NAndTime[i][0] * 0.0001, NAndTime[i][1] / max, NAndTime[i + 1][0] * 0.0001, NAndTime[i + 1][1] / max);
        }
    }

    private void drawLogPlot(double[][] NAndTime, int NAndTimeSize, double max) {
        for (int i = 0; i < NAndTimeSize; i++) {
            // X axis
            if (NAndTimeSize == 1) {
                StdDraw.line((Math.log(NAndTime[0][0] * 100) * 0.1) + 0.7, 0.0, (Math.log(NAndTime[0][0] * 100) * 0.1) + 0.7 + 0.1, 0.0);
            } else {
                StdDraw.line((Math.log(NAndTime[0][0] * 100) * 0.1) + 0.7, 0.0, (Math.log(NAndTime[NAndTimeSize - 1][0] * 100) * 0.1) + 0.7, 0.0);
            }
            // Y axis
            if (NAndTimeSize == 1) {
                StdDraw.line((Math.log(NAndTime[0][0] * 100) * 0.1) + 0.6, Math.log(NAndTime[0][1] * 100) / Math.log(max * 100), (Math.log(NAndTime[0][0] * 100) * 0.1) + 0.6, 0.1);
            } else {
                StdDraw.line((Math.log(NAndTime[0][0] * 100) * 0.1) + 0.6, Math.log(1.1), (Math.log(NAndTime[0][0] * 100) * 0.1) + 0.6, (Math.log(NAndTime[NAndTimeSize - 1][1] * 100) / Math.log(max * 100)) + 0.1);
            }
            // Y axis serifs
            StdDraw.line((Math.log(NAndTime[0][0] * 100) * 0.1) + 0.6, Math.log(NAndTime[i][1] * 100) / Math.log(max * 100), (Math.log(NAndTime[0][0] * 100) * 0.1) + 0.6 - 0.05, Math.log(NAndTime[i][1] * 100) / Math.log(max * 100));
            // X axis serifs
            StdDraw.line((Math.log(NAndTime[i][0] * 100) * 0.1) + 0.7, 0.0, (Math.log(NAndTime[i][0] * 100) * 0.1) + 0.7, -0.05);
            // Y axis digits
            StdDraw.text((Math.log(NAndTime[0][0] * 100) * 0.1) + 0.45, Math.log(NAndTime[i][1] * 100) / Math.log(max * 100), NAndTime[i][1] + "");
            // X axis digits
            StdDraw.text((Math.log(NAndTime[i][0] * 100) * 0.1) + 0.7, -0.1, (int) (NAndTime[i][0] * 0.001) + "K");
        }
    }

    private void drawLogCurve(double[][] NAndTime, int NAndTimeSize, double max) {
        for (int i = 0; i < NAndTimeSize; i++) {
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.setPenRadius(StdDraw.getPenRadius() + 0.009);
            // Print point coordinates
            StdDraw.point((Math.log(NAndTime[i][0] * 100) * 0.1) + 0.7, Math.log(NAndTime[i][1] * 100) / Math.log(max * 100));
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.setPenRadius(StdDraw.getPenRadius() - 0.009);
        }
        for (int i = 0; i < NAndTimeSize - 1; i++) {
            StdDraw.line((Math.log(NAndTime[i][0] * 100) * 0.1) + 0.7, (Math.log(NAndTime[i][1] * 100) / Math.log(max * 100)), (Math.log(NAndTime[i + 1][0] * 100) * 0.1) + 0.7, (Math.log(NAndTime[i + 1][1] * 100) / (Math.log(max * 100))));
        }
    }
}


