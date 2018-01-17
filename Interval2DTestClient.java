public class Interval2DTestClient {
    public static void main(String[] args)
    {
        double xlo = Double.parseDouble(args[0]);
        double xhi = Double.parseDouble(args[1]);
        double ylo = Double.parseDouble(args[2]);
        double yhi = Double.parseDouble(args[3]);
        int T = Integer.parseInt(args[4]);
        Interval1D x = new Interval1D(xlo, xhi);
        Interval1D y = new Interval1D(ylo, yhi);
        Interval2D box = new Interval2D(x, y);
        StdDraw.setYscale(0.0, 25.0);
        StdDraw.setXscale(0.0, 25.0);
        box.draw();
        Counter c = new Counter("hits");
        for (int t = 0; t < T; t++)
        {
            double pointX = Math.random()*25;
            double pointY = Math.random()*25;
                Point2D p = new Point2D(pointX, pointY);
            if (box.contains(p)) c.increment();
else
            p.draw();
        }
        StdOut.println(c);
        StdOut.println(box.area());
    }
}
