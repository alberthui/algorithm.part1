import java.math.BigInteger;
import java.util.HashMap;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class BruteCollinearPoints {
    Point[] points;

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        this.points = points;
    }

    // the number of line segments
    public int numberOfSegments() {
        int result = 0;

        for (Point p : points) {
            HashMap<Double, BigInteger> map = new HashMap<>();

            for (Point q : points) {
                Double slope = p.slopeTo(q);
                if (map.containsKey(Double.valueOf(Math.abs(slope)))) {
                    map.put(Double.valueOf(Math.abs(slope)), map.get(Double.valueOf(Math.abs(slope))).add(BigInteger.ONE));
                } else {
                    map.put(Double.valueOf(Math.abs(slope)), BigInteger.ONE);
                }
            }

            for (BigInteger i : map.values()) {
                if (i.intValue() >= 4) {
                    result++;
                }
            }
        }

        return result;
    }

    // the line segments
    public LineSegment[] segments() {

    }

    public static void main(String[] args) {

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
