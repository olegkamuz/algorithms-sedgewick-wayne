import java.awt.Color;
public class Exercise123_Interval2DIntersect {
    public static void main(String[] args){
        int N = 13;
        Interval2DHelper[] interval2DArr = makeInterval2DArr(N);
        drawAllIntervals(interval2DArr, 500);
        IntersectInterval2D[] intersectIntervals = calculateIntersects(N, interval2DArr);
        drawIntersectPairs(intersectIntervals, 1000);
        printIntersectIntervalsPairs(intersectIntervals);
        System.out.println();
        ContainsInterval2D[] containsIntervals = calculateContains(N, interval2DArr);
        drawContainsPairs(containsIntervals, 1000);
        printContainsIntervalsPairs(containsIntervals);
        printIntersectAndContainsCounts(intersectIntervals,containsIntervals);

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
        System.out.println("Intersecting intervals respective pairs: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("min: %1.4f max:%1.4f min: %1.4f max %1.4f",arr[i].firstInterval.x.min(), arr[i].firstInterval.x.max(), arr[i].secondInterval.y.min(), arr[i].secondInterval.y.max());
            System.out.println();
        }
    }
    private static void printContainsIntervalsPairs(ContainsInterval2D[] arr){
        System.out.println("Containing intervals respective pairs: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Xmin: %1.4f Xmax:%1.4f Ymin: %1.4f Ymax %1.4f",arr[i].firstInterval.x.min(), arr[i].firstInterval.x.max(), arr[i].firstInterval.y.min(), arr[i].firstInterval.y.max());
            System.out.println();
            System.out.printf("Xmin: %1.4f Xmax:%1.4f Ymin: %1.4f Ymax %1.4f",arr[i].secondInterval.x.min(), arr[i].secondInterval.x.max(), arr[i].secondInterval.y.min(), arr[i].secondInterval.y.max());
            System.out.println();
            System.out.println();
        }
    }
    private static void printIntersectAndContainsCounts(IntersectInterval2D[] intersect, ContainsInterval2D[] contains){
        System.out.printf("Intersects: %1d, Contains: %1d", intersect.length, contains.length);
    }

    private static void drawAllIntervals(Interval2DHelper[] intervalArr, int speed){
        StdDraw.setPenRadius(.004);
        StdDraw.setPenColor(StdDraw.BLUE);
        for (int i = 0; i < intervalArr.length; i++) {
            double minX = intervalArr[i].x.min();
            double maxX = intervalArr[i].x.max();
            double minY = intervalArr[i].y.min();
            double maxY = intervalArr[i].y.max();
            StdDraw.rectangle(minX+(maxX - minX)/2, minY+(maxY - minY)/2, (maxX - minX)/2,(maxY - minY)/2) ;
            StdDraw.pause(speed);
        }
        StdDraw.pause(2000);

    }
    private static void drawContainsPairs(ContainsInterval2D[] arr, int speed){
        for (int i = 0; i < arr.length; i++) {
            StdDraw.setPenRadius(.005);
            StdDraw.setPenColor(StdDraw.GREEN);
            double minX = arr[i].firstInterval.x.min();
            double maxX = arr[i].firstInterval.x.max();
            double minY = arr[i].firstInterval.y.min();
            double maxY = arr[i].firstInterval.y.max();
            StdDraw.rectangle(minX + (maxX - minX) / 2, minY + (maxY - minY) / 2, (maxX - minX) / 2, (maxY - minY) / 2);
            double minXsecond = arr[i].secondInterval.x.min();
            double maxXsecond = arr[i].secondInterval.x.max();
            double minYsecond = arr[i].secondInterval.y.min();
            double maxYsecond = arr[i].secondInterval.y.max();
            StdDraw.rectangle(minXsecond + (maxXsecond - minXsecond) / 2, minYsecond + (maxYsecond - minYsecond) / 2, (maxXsecond - minXsecond) / 2, (maxYsecond - minYsecond) / 2);
            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            StdDraw.setPenRadius(.006);
            StdDraw.pause(speed);
            StdDraw.rectangle(minX + (maxX - minX) / 2, minY + (maxY - minY) / 2, (maxX - minX) / 2, (maxY - minY) / 2);
            StdDraw.rectangle(minXsecond + (maxXsecond - minXsecond) / 2, minYsecond + (maxYsecond - minYsecond) / 2, (maxXsecond - minXsecond) / 2, (maxYsecond - minYsecond) / 2);
        }
        StdDraw.pause(2000);
    }
    private static void drawIntersectPairs(IntersectInterval2D[] arr, int speed){
        for (int i = 0; i < arr.length; i++) {
            StdDraw.setPenRadius(.004);
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
            StdDraw.setPenRadius(.006);
            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            StdDraw.pause(speed);
            StdDraw.rectangle(minX+(maxX - minX)/2, minY+(maxY - minY)/2, (maxX - minX)/2,(maxY - minY)/2) ;
            StdDraw.rectangle(minXsecond+(maxXsecond - minXsecond)/2, minYsecond+(maxYsecond - minYsecond)/2, (maxXsecond - minXsecond)/2,(maxYsecond - minYsecond)/2) ;
            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        }
        StdDraw.pause(2000);
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


