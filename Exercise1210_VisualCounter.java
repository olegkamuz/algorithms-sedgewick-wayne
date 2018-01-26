public class Exercise1210_VisualCounter {
    private int count = 0;
    private int countOperations = 0;
    private int N;
    private int max;

    public Exercise1210_VisualCounter(int N, int max) {
        this.N = N;
        this.max = max;
        setDrawSettings();
    }
    public void increment(){
        if(!isMaxValue()) {
            incrementOperations();
            this.count++;
            drawPlot();
        }
        if(!isMaxOperations()){
           drawPlot();
        }
    }
    public void decrement(){
        if(!isMaxOperations()) {
            incrementOperations();
            this.count--;
            drawPlot();
        }
    }
    public int tally(){
        return this.count;
    }
    private void setDrawSettings(){
        StdDraw.setXscale(0.0, (double) this.N);
        StdDraw.setYscale(0.0, (double) this.max);
    }
    private void drawPlot(){
        StdDraw.filledRectangle((double)this.countOperations - 0.5, this.count / 2.0, 0.25, this.count / 2.0);
    }
    private void incrementOperations(){
        this.countOperations++;
    }
    private boolean isMaxOperations(){
        if(this.countOperations < this.N) return false;
        else return true;
    }
    private boolean isMaxValue(){
        if(this.count < this.max) return false;
        else return true;
    }

    public static void main(String[] args){
        Exercise1210_VisualCounter visualCounter = new Exercise1210_VisualCounter(8, 4);
        visualCounter.increment(); // count: 1, countOperations: 1
        visualCounter.increment(); // 2, 2
        visualCounter.decrement(); // 1, 3
        visualCounter.increment(); // 2, 4
        visualCounter.increment(); // 3, 5
        visualCounter.increment(); // 4, 6
        visualCounter.increment(); // 4, 7
        visualCounter.decrement(); // 3, 8 (last operation)
        visualCounter.decrement(); // 3, 8
    }
}
