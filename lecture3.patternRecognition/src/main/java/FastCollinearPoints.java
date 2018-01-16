import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class FastCollinearPoints {
    Point[] points;
    LineSegment[] lineSegments = null;

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points){
        this.points = points;
    }

    // the number of line segments
    public int numberOfSegments(){
        if (lineSegments==null) {
            segments();
        }
        return lineSegments.length;
    }

    // the line segments
    public LineSegment[] segments(){
        List<LineSegment> result = new ArrayList<>();
        for (int i=0;i<points.length-3;i++) {
            for (int j = i + 1; j < points.length - 2; j++) {

            }
        }
        lineSegments = result.toArray(new LineSegment[result.size()]);
        return lineSegments;
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
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
