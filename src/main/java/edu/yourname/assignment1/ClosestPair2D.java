package edu.yourname.assignment1;

import java.util.*;

public class ClosestPair2D {
    public static class Point {
        public double x,y;
        public Point(double x,double y){this.x=x;this.y=y;}
    }

    public static double closestPair(Point[] pts) {
        Point[] sortedX = pts.clone();
        Arrays.sort(sortedX, Comparator.comparingDouble(p -> p.x));
        return closest(sortedX, 0, pts.length - 1);
    }

    private static double closest(Point[] pts, int lo, int hi) {
        if (hi - lo <= 3) return bruteForce(pts, lo, hi);
        int mid = (lo + hi) / 2;
        double d1 = closest(pts, lo, mid);
        double d2 = closest(pts, mid+1, hi);
        double d = Math.min(d1, d2);
        List<Point> strip = new ArrayList<>();
        double midx = pts[mid].x;
        for (int i = lo; i <= hi; i++) {
            if (Math.abs(pts[i].x - midx) < d) strip.add(pts[i]);
        }
        strip.sort(Comparator.comparingDouble(p -> p.y));
        for (int i = 0; i < strip.size(); i++) {
            for (int j = i+1; j<strip.size() && (strip.get(j).y - strip.get(i).y)<d; j++) {
                d = Math.min(d, dist(strip.get(i), strip.get(j)));
            }
        }
        return d;
    }

    private static double bruteForce(Point[] pts, int lo, int hi) {
        double d = Double.POSITIVE_INFINITY;
        for (int i = lo; i <= hi; i++)
            for (int j = i+1; j<=hi; j++)
                d = Math.min(d, dist(pts[i], pts[j]));
        return d;
    }

    private static double dist(Point a, Point b) {
        double dx = a.x-b.x, dy=a.y-b.y;
        return Math.sqrt(dx*dx+dy*dy);
    }
}
