import java.awt.Color;
public class Exercise123_Interval2DIntersect {
    public static void main(String[] args){
        int N = 30;
        Interval2DHelper[] interval2DArr = makeInterval2DArr(N);
        IntersectInterval2D[] intersectIntervals = calculateIntersects(N, interval2DArr);
        ContainsInterval2D[] containsIntervals = calculateContains(N, interval2DArr);
//        printIntersectIntervalsPairs(intersectIntervals);
        System.out.println();
        printContainsIntervalsPairs(containsIntervals);

    }
    private static Interval2DHelper[] makeInterval2DArr(int N){
        Interval2DHelper[] intervalArr = new Interval2DHelper[N];
        for (int i = 0; i < intervalArr.length; i++) {
            double minX = StdRandom.uniform(0.0, 1.0);
            double maxX = StdRandom.uniform(0.0, 1.0);
            double minY = StdRandom.uniform(0.0, 1.0);
            double maxY = StdRandom.uniform(0.0, 1.0);
            if(minX > maxX){
                double t;
                t = minX;
                minX = maxX;
                maxX = t;
            }
            if(minY > maxY){
                double t;
                t = minY;
                minY = maxY;
                maxY = t;
            }
            Interval1D intervalX = new Interval1D(minX, maxX);
            Interval1D intervalY = new Interval1D(minY, maxY);
            intervalArr[i] = new Interval2DHelper(intervalX, intervalY);
            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            StdDraw.setScale(0.0, 1.0);
            StdDraw.setPenRadius(.003);
            StdDraw.rectangle(minX+(maxX - minX)/2, minY+(maxY - minY)/2, (maxX - minX)/2,(maxY - minY)/2) ;
        }
        return intervalArr;
    }

    private static IntersectInterval2D[] calculateIntersects(int N, Interval2DHelper[] interval2DArr){
        IntersectInterval2D[] intersectIntervals = new IntersectInterval2D[N*N];
        int intersectCount = 0;
        for (int i = 0; i < interval2DArr.length - 1; i++) {
            for (int j = i + 1; j < interval2DArr.length; j++) {
                if (interval2DArr[i].intersects(interval2DArr[j])) {
                    intersectIntervals[intersectCount] = new IntersectInterval2D(interval2DArr[i], interval2DArr[j]);
                    intersectCount++;
                }
            }
        }
        return popNulls(intersectIntervals, intersectCount);
    }
    private static ContainsInterval2D[] calculateContains(int N, Interval2DHelper[] interval2DArr){
        ContainsInterval2D[] containsIntervals = new ContainsInterval2D[N*N];
        int containsCount = 0;
        for (int i = 0; i < interval2DArr.length - 1; i++) {
            for (int j = i + 1; j < interval2DArr.length; j++) {
                if (interval2DArr[i].x.min() >= interval2DArr[j].x.min() &&  interval2DArr[i].x.max() <= interval2DArr[j].x.max() && interval2DArr[i].y.min() >= interval2DArr[j].y.min() &&  interval2DArr[i].y.max() <= interval2DArr[j].y.max()) {
                    containsIntervals[containsCount] = new ContainsInterval2D(interval2DArr[i], interval2DArr[j]);
                    containsCount++;
                }
            }
        }
        return popNulls(containsIntervals, containsCount);
    }

    private static IntersectInterval2D[] popNulls(IntersectInterval2D[] intersectIntervals, int count){
        IntersectInterval2D[] noNullsArr = new IntersectInterval2D[count];
        for (int i = 0; i < intersectIntervals.length; i++) {
            if (intersectIntervals[i] != null) noNullsArr[i] = intersectIntervals[i];
        }
        return noNullsArr;
    }
    private static ContainsInterval2D[] popNulls(ContainsInterval2D[] containsIntervals, int count){
        ContainsInterval2D[] noNullsArr = new ContainsInterval2D[count];
        for (int i = 0; i < containsIntervals.length; i++) {
            if (containsIntervals[i] != null) noNullsArr[i] = containsIntervals[i];
        }
        return noNullsArr;
    }
    private static void printIntersectIntervalsPairs(IntersectInterval2D[] arr){
//        System.out.println("Intersecting intervals respective pairs: ");
        for (int i = 0; i < arr.length; i++) {
            StdDraw.setPenRadius(0.005);
            StdDraw.setPenColor(StdDraw.RED);
            double minX = arr[i].firstInterval.x.min();
            double maxX = arr[i].firstInterval.x.max();
            double minY = arr[i].firstInterval.y.min();
            double maxY = arr[i].firstInterval.y.max();
                        StdDraw.rectangle(minX+(maxX - minX)/2, minY+(maxY - minY)/2, (maxX - minX)/2,(maxY - minY)/2) ;
            double minXsecond = arr[i].secondInterval.x.min();
            double maxXsecond = arr[i].secondInterval.x.max();
            double minYsecond = arr[i].secondInterval.y.min();
            double maxYsecond = arr[i].secondInterval.y.max();
            StdDraw.rectangle(minXsecond+(maxXsecond - minXsecond)/2, minYsecond+(maxYsecond - minYsecond)/2, (maxXsecond - minXsecond)/2,(maxYsecond - minYsecond)/2) ;

            System.out.printf("min: %1.4f max:%1.4f min: %1.4f max %1.4f",arr[i].firstInterval.x.min(), arr[i].firstInterval.x.max(), arr[i].secondInterval.y.min(), arr[i].secondInterval.y.max());
            System.out.println();
        }
    }
    private static void printContainsIntervalsPairs(ContainsInterval2D[] arr){
        System.out.println("Containing intervals respective pairs: ");
        for (int i = 0; i < arr.length; i++) {
            StdDraw.setPenRadius(.003);
            int r = StdRandom.uniform(0, 255);
            int g = StdRandom.uniform(0, 255);
            int b = StdRandom.uniform(0, 255);
            StdDraw.setPenColor(r, g, b);
            double minX = arr[i].firstInterval.x.min();
            double maxX = arr[i].firstInterval.x.max();
            double minY = arr[i].firstInterval.y.min();
            double maxY = arr[i].firstInterval.y.max();
            StdDraw.rectangle(minX+(maxX - minX)/2, minY+(maxY - minY)/2, (maxX - minX)/2,(maxY - minY)/2) ;
            double minXsecond = arr[i].secondInterval.x.min();
            double maxXsecond = arr[i].secondInterval.x.max();
            double minYsecond = arr[i].secondInterval.y.min();
            double maxYsecond = arr[i].secondInterval.y.max();
            StdDraw.rectangle(minXsecond+(maxXsecond - minXsecond)/2, minYsecond+(maxYsecond - minYsecond)/2, (maxXsecond - minXsecond)/2,(maxYsecond - minYsecond)/2) ;
            StdDraw.pause(500);
            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            StdDraw.rectangle(minXsecond+(maxXsecond - minXsecond)/2, minYsecond+(maxYsecond - minYsecond)/2, (maxXsecond - minXsecond)/2,(maxYsecond - minYsecond)/2) ;
//            System.out.printf("Xmin: %1.4f Xmax:%1.4f Ymin: %1.4f Ymax %1.4f",arr[i].firstInterval.x.min(), arr[i].firstInterval.x.max(), arr[i].firstInterval.y.min(), arr[i].firstInterval.y.max());
//            System.out.println();
//            System.out.printf("Xmin: %1.4f Xmax:%1.4f Ymin: %1.4f Ymax %1.4f",arr[i].secondInterval.x.min(), arr[i].secondInterval.x.max(), arr[i].secondInterval.y.min(), arr[i].secondInterval.y.max());
//            System.out.println();
//            System.out.println();
        }
    }
}

class IntersectInterval2D{
    public Interval2DHelper firstInterval;
    public Interval2DHelper secondInterval;
    public IntersectInterval2D(Interval2DHelper firstInterval, Interval2DHelper secondInterval){
        this.firstInterval = firstInterval;
        this.secondInterval = secondInterval;
    }
}

class ContainsInterval2D{
    public Interval2DHelper firstInterval;
    public Interval2DHelper secondInterval;
    public ContainsInterval2D(Interval2DHelper firstInterval, Interval2DHelper secondInterval){
        this.firstInterval = firstInterval;
        this.secondInterval = secondInterval;
    }
}

class Interval2DHelper extends Interval2D{
    public Interval1D x;
    public Interval1D y;

    public Interval2DHelper(Interval1D x, Interval1D y) {
        super(x, y);
        this.x = x;
        this.y = y;
    }
}


