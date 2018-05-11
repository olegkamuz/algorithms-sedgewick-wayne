import java.io.IOException;

public class Exercise143_DoublingTestPlot {
    public static void main(String[] args) throws InterruptedException, IOException {
        int numberOfTests = 4; // same as number point at curve
        boolean cached = true;
        DoublingTestPlot doublingTestPlot = new DoublingTestPlot(numberOfTests, cached);
        doublingTestPlot.plot();
    }
}
