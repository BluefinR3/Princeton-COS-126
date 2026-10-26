/* *****************************************************************************
 *  Name:    Roshan Srivastava

 *  Description:  Generates a Sierpinski triangle using recursion
 *
 **************************************************************************** */

public class Sierpinski {

    //  Height of an equilateral triangle whose sides are of the specified length.
    public static double height(double length) {
        return (Math.sqrt(3) / 2) * length;
    }

    //  Draws a filled equilateral triangle whose bottom vertex is (x, y)
    //  of the specified side length.
    public static void filledTriangle(double x, double y, double length) {
        double half = length / 2;
        // for triangle.
        double[] xPositions = {x, x - half, x + half};
        double[] yPositions = {y, y + height(length), y + height(length)};
        StdDraw.filledPolygon(xPositions, yPositions);
    }

    //  Draws a Sierpinski triangle of order n, such that the largest filled
    //  triangle has bottom vertex (x, y) and sides of the specified length.
    public static void sierpinski(int n, double x, double y, double length) {
        if (n != 0) {
            filledTriangle(x, y, length);
            double half = length / 2;
            sierpinski(n - 1, x, y + height(length), half);
            sierpinski(n - 1, x - half, y, half);
            sierpinski(n - 1, x + half, y, half);
        }
    }

    //  Takes an integer command-line argument n;
    //  draws the outline of an equilateral triangle (pointed upwards) of length 1;
    //  whose bottom-left vertex is (0, 0) and bottom-right vertex is (1, 0); and
    //  draws a Sierpinski triangle of order n that fits snugly inside the outline.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.polygon(new double[]{0, 0.5, 1},
                        new double[]{0, Sierpinski.height(1), 0});
        sierpinski(n, 0.5, 0, 0.5);
    }

}
