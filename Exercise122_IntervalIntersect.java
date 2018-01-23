public class Exercise122_IntervalIntersect {
    public static void main(String[] args){
        int N = 50;
        Interval1D[] intervalArr = makeIntervalArr(N);
        IntersectInterval[] intersectIntervals = calculateIntersects(N, intervalArr);
        printIntersectIntervalsPairs(intersectIntervals);

    }
    private static Interval1D[] makeIntervalArr(int N){
        Interval1D[] intervalArr = new Interval1D[N];
        for (int i = 0; i < intervalArr.length; i++) {
            double min = StdRandom.uniform(0.0, 1.0);
            double max = StdRandom.uniform(0.0, 1.0);
            if(min > max){
                double t;
                t = min;
                min = max;
                max = t;
            }
            intervalArr[i] = new Interval1D(min, max);
        }
        return intervalArr;
    }
    private static IntersectInterval[] calculateIntersects(int N, Interval1D[] intervalArr){
        IntersectInterval[] intersectIntervals = new IntersectInterval[N*N];
        int count = 0;
        for (int i = 0; i < intervalArr.length - 1; i++) {
            for (int j = i + 1; j < intervalArr.length; j++) {
                if (intervalArr[i].intersects(intervalArr[j])) {
                    intersectIntervals[count] = new IntersectInterval(intervalArr[i], intervalArr[j]);
                    count++;
                }
            }
        }
        return popNulls(intersectIntervals, count);
    }
    private static IntersectInterval[] popNulls(IntersectInterval[] intersectIntervals, int count){
        IntersectInterval[] noNullsArr = new IntersectInterval[count];
        for (int i = 0; i < intersectIntervals.length; i++) {
            if (intersectIntervals[i] != null) noNullsArr[i] = intersectIntervals[i];
        }
        return noNullsArr;
    }
    private static void printIntersectIntervalsPairs(IntersectInterval[] arr){
        System.out.println("Intersecting intervals respective pairs: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("min: %1.4f max:f%1.4f min: %1.4f max %1.4f",arr[i].firstInterval.min(), arr[i].firstInterval.max(), arr[i].secondInterval.min(), arr[i].secondInterval.max());
            System.out.println();
        }
    }
}

class IntersectInterval{
    public Interval1D firstInterval;
    public Interval1D secondInterval;
    public IntersectInterval(Interval1D firstInterval, Interval1D secondInterval){
        this.firstInterval = firstInterval;
        this.secondInterval = secondInterval;
    }
}
