/* *****************************************************************************
 *  Name:    Roshan Srivastavas
 *  Description: Creates a recursive drawing of your own design
 **************************************************************************** */
public class Art {

    // It will draw the square using the x, y and length.
    private static void drawSquareShape(double x, double y, double length) {
        double half = length / 2;
        double[] xPositions = {x - half, x + half, x + half, x - half};
        double[] yPositions = {y - half, y - half, y + half, y + half};
        StdDraw.polygon(xPositions, yPositions);
    }

    // It will draw the square at the center, and then draw the half length square
    // on the top-left, top-right, bottom-left and bottom-right position.
    private static void drawSquareFourSided(int n, double x, double y, double length) {
        if (n != 0) {
            drawSquareShape(x, y, length);
            double half = length / 2;
            drawSquareFourSided(n - 1, x - half, y + half, half);
            drawSquareFourSided(n - 1, x + half, y + half, half);
            drawSquareFourSided(n - 1, x - half, y - half, half);
            drawSquareFourSided(n - 1, x + half, y - half, half);
        }
    }

    // the main method to take the number and draw the recursive based design.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(-1, 1);
        drawSquareFourSided(n, 0, 0, 0.5);
    }

}
