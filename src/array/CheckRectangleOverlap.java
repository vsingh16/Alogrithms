package com.vishal.hackerrank;

/**
 * Created by vishal on 24-Dec-20.
 * <p>
 * Note that a rectangle can be represented by two coordinates, top left and bottom right. So mainly we are given following four coordinates.
 * l1: Top Left coordinate of first rectangle.
 * r1: Bottom Right coordinate of first rectangle.
 * l2: Top Left coordinate of second rectangle.
 * r2: Bottom Right coordinate of second rectangle.
 * Check if they overlap
 */
public class CheckRectangleOverlap {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * Method : Two rectangles overlap if
     * top left. X of rectangle 1 < right bottom.X of rectangle 2 and
     * top left. Y of rectangle 1 > right bottom.Y of rectangle 2
     * PS: Compare top left with right bottom to derive equations
     *
     * @return
     */
    public static boolean checkOverlap(Point l1, Point r1, Point l2, Point r2) {

        if (l1.x >= r2.x || l2.x >= r1.x) {
            return false;
        } else if (l1.y <= r2.y || l2.y <= r1.y) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkOverlap(new Point(0, 10), new Point(10, 0), new Point(5, 5), new Point(15, 0)));


    }
}
