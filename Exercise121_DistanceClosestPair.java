public class Exercise121_DistanceClosestPair {
    public static void main(String[] args){
        int N = 40;
        Point2D[] pointsArr = makePointsArr(N);
        double[] minArr = makeMinArr(N, pointsArr);
        double min = calculateMinDistance(minArr);
        System.out.println(min);
    }
    private static Point2D[] makePointsArr(int N){
        Point2D[] pointArr = new Point2D[N];
        for(int i = 0; i < N; i++) {
            double x = StdRandom.uniform(0.0, 1.0);
            double y = StdRandom.uniform(0.0, 1.0);
            pointArr[i] = new Point2D(x, y);
        }
        return pointArr;
    }
    private static double[] makeMinArr(int N, Point2D[] pointArr){
        double[] minArr = new double[N - 1];
        for (int i = 0; i < N - 1; i++) {
            double min = 0.0;
            for (int j = i + 1; j < N; j++) {
                double res = pointArr[i].distanceTo(pointArr[j]);
                if (min == 0.0) min = res;
                if (res < min) min = res;
            }
            minArr[i] = min;
        }
        return minArr;
    }
    private static double calculateMinDistance(double[] minArr){
        double minDistance = 0.0;
        for (int i = 0; i < minArr.length; i++) {
            if (minDistance == 0.0) minDistance = minArr[i];
            if (minArr[i] < minDistance) minDistance = minArr[i];
        }
        return minDistance;
    }
}
