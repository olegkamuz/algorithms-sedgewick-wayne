import java.io.IOException;

/**
 * Visualisation: https://www.youtube.com/watch?v=V76D9ClMx3g
 */

public class Exercise143_DoublingTestPlot {
    public static void main(String[] args) throws InterruptedException, IOException {
        int numberOfTests = 4; // same as number point at curve
        boolean cached = true;
        DoublingTestPlot doublingTestPlot = new DoublingTestPlot(numberOfTests, cached);
        doublingTestPlot.plot();
    }
}
