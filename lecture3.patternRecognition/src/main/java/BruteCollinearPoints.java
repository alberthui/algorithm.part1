import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class BruteCollinearPoints {
    Point[] points;
    LineSegment[] lineSegments = null;

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        this.points = points;
    }

    // the number of line segments
    public int numberOfSegments() {
        if (lineSegments==null) {
            segments();
        }
        return lineSegments.length;
    }

    // the line segments
    public LineSegment[] segments() {
        List<LineSegment> result = new ArrayList<>();
        for (int i=0;i<points.length-3;i++) {
            for (int j=i+1; j<points.length-2;j++) {
                for (int k=j+1; k<points.length-1; k++) {
                    for (int l=k+1; l<points.length;l++) {
                        Point a = points[i];
                        Point b = points[j];
                        Point c = points[k];
                        Point d = points[l];

                        if (a.slopeTo(b) == b.slopeTo(c)
                                && b.slopeTo(c) == c.slopeTo(d)) {

                            Point[] list = {a,b,c,d};
                            Arrays.sort(list);
                            result.add(new LineSegment(list[0],list[3]));
                        }
                    }
                }
            }
        }
        lineSegments = result.toArray(new LineSegment[result.size()]);
        return lineSegments;
    }

    public static void main(String[] args) {
        System.out.println(BruteCollinearPoints.class.getClassLoader().getResource(".").getPath());
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